package com.taverncall.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import com.taverncall.model.MapToken
import kotlin.math.max
import kotlin.math.min

class BattleMapView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var backgroundImage: Bitmap? = null
    private var tokens = mutableListOf<MapToken>()
    private var showGrid = false
    private val gridSize = 48f * resources.displayMetrics.density

    private var scaleFactor = 1.0f
    private var offsetX = 0f
    private var offsetY = 0f

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val gridPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.LTGRAY
        alpha = 100
        strokeWidth = 2f
        style = Paint.Style.STROKE
    }

    private val scaleDetector = ScaleGestureDetector(context, object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            scaleFactor *= detector.scaleFactor
            scaleFactor = max(0.5f, min(scaleFactor, 5.0f))
            invalidate()
            return true
        }
    })

    private val gestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
        override fun onScroll(e1: MotionEvent?, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
            offsetX -= distanceX
            offsetY -= distanceY
            invalidate()
            return true
        }
    })

    private var selectedToken: MapToken? = null

    fun setBackgroundImage(bitmap: Bitmap) {
        backgroundImage = bitmap
        invalidate()
    }

    fun setTokens(newTokens: List<MapToken>) {
        tokens = newTokens.toMutableList()
        invalidate()
    }

    fun setShowGrid(show: Boolean) {
        showGrid = show
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        canvas.translate(offsetX, offsetY)
        canvas.scale(scaleFactor, scaleFactor)

        // Desenhar fundo
        backgroundImage?.let {
            canvas.drawBitmap(it, 0f, 0f, paint)
        }

        // Desenhar grade
        if (showGrid) {
            val width = backgroundImage?.width?.toFloat() ?: width.toFloat()
            val height = backgroundImage?.height?.toFloat() ?: height.toFloat()
            
            var x = 0f
            while (x <= width) {
                canvas.drawLine(x, 0f, x, height, gridPaint)
                x += gridSize
            }
            var y = 0f
            while (y <= height) {
                canvas.drawLine(0f, y, width, y, gridPaint)
                y += gridSize
            }
        }

        // Desenhar tokens
        for (token in tokens) {
            paint.color = token.color
            paint.style = Paint.Style.FILL
            canvas.drawCircle(token.x, token.y, 24f * resources.displayMetrics.density, paint)

            paint.color = Color.WHITE
            paint.textSize = 16f * resources.displayMetrics.density
            paint.textAlign = Paint.Align.CENTER
            val initial = if (token.name.isNotEmpty()) token.name[0].toString().uppercase() else "?"
            canvas.drawText(initial, token.x, token.y + 6f * resources.displayMetrics.density, paint)
        }

        canvas.restore()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        scaleDetector.onTouchEvent(event)
        gestureDetector.onTouchEvent(event)

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                val x = (event.x - offsetX) / scaleFactor
                val y = (event.y - offsetY) / scaleFactor
                selectedToken = findTokenAt(x, y)
            }
            MotionEvent.ACTION_MOVE -> {
                if (selectedToken != null && event.pointerCount == 1) {
                    val x = (event.x - offsetX) / scaleFactor
                    val y = (event.y - offsetY) / scaleFactor
                    selectedToken?.x = x
                    selectedToken?.y = y
                    invalidate()
                }
            }
            MotionEvent.ACTION_UP -> {
                selectedToken = null
            }
        }
        return true
    }

    private fun findTokenAt(x: Float, y: Float): MapToken? {
        val radius = 24f * resources.displayMetrics.density
        return tokens.find { token ->
            val dx = token.x - x
            val dy = token.y - y
            (dx * dx + dy * dy) <= radius * radius
        }
    }
}
