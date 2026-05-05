import { Button } from "@/components/ui/button";
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { Gamepad2, Map, Users, Volume2, Dice5 } from "lucide-react";

export default function Home() {
  return (
    <div className="min-h-screen bg-gradient-to-br from-slate-900 via-slate-800 to-slate-900">
      {/* Header */}
      <header className="border-b border-slate-700 bg-slate-900/50 backdrop-blur-sm sticky top-0 z-50">
        <div className="container max-w-7xl mx-auto px-4 py-4 flex items-center justify-between">
          <div className="flex items-center gap-3">
            <div className="w-10 h-10 bg-gradient-to-br from-red-500 to-red-700 rounded-lg flex items-center justify-center">
              <Gamepad2 className="w-6 h-6 text-white" />
            </div>
            <h1 className="text-2xl font-bold text-white">TavernCall 2.0</h1>
          </div>
          <nav className="hidden md:flex gap-6">
            <a href="#features" className="text-slate-300 hover:text-white transition">Funcionalidades</a>
            <a href="#modules" className="text-slate-300 hover:text-white transition">Módulos</a>
            <a href="#download" className="text-slate-300 hover:text-white transition">Download</a>
          </nav>
        </div>
      </header>

      {/* Hero Section */}
      <section className="container max-w-7xl mx-auto px-4 py-20 md:py-32">
        <div className="text-center mb-12">
          <h2 className="text-4xl md:text-6xl font-bold text-white mb-6 leading-tight">
            Uma Mesa de RPG Completa
            <br />
            <span className="bg-gradient-to-r from-red-400 to-red-600 bg-clip-text text-transparent">
              Em Um Único App
            </span>
          </h2>
          <p className="text-xl text-slate-300 mb-8 max-w-2xl mx-auto">
            Unifica videochamada, mapa de batalha, ficha de personagem D&D 5e, soundboard e rolador de dados. 
            Tudo que você precisa para uma sessão imersiva, sem alternar entre aplicativos.
          </p>
          <div className="flex flex-col sm:flex-row gap-4 justify-center">
            <Button size="lg" className="bg-red-600 hover:bg-red-700 text-white">
              Baixar Agora
            </Button>
            <Button size="lg" variant="outline" className="border-slate-600 text-white hover:bg-slate-800">
              Ver Documentação
            </Button>
          </div>
        </div>
      </section>

      {/* Features Section */}
      <section id="features" className="container max-w-7xl mx-auto px-4 py-16">
        <h3 className="text-3xl font-bold text-white mb-12 text-center">Por que TavernCall 2.0?</h3>
        <div className="grid md:grid-cols-3 gap-6">
          <Card className="bg-slate-800 border-slate-700 hover:border-red-500/50 transition">
            <CardHeader>
              <Users className="w-8 h-8 text-red-500 mb-2" />
              <CardTitle className="text-white">Jitsi Meet Integrado</CardTitle>
            </CardHeader>
            <CardContent className="text-slate-300">
              Videochamada sempre visível, ocupando 65% da tela. Comunique-se sem deixar as ferramentas.
            </CardContent>
          </Card>

          <Card className="bg-slate-800 border-slate-700 hover:border-red-500/50 transition">
            <CardHeader>
              <Map className="w-8 h-8 text-red-500 mb-2" />
              <CardTitle className="text-white">Mapa de Batalha</CardTitle>
            </CardHeader>
            <CardContent className="text-slate-300">
              Tokens arrastáveis, grade opcional, zoom e pan. Carregue imagens do dispositivo ou via URL.
            </CardContent>
          </Card>

          <Card className="bg-slate-800 border-slate-700 hover:border-red-500/50 transition">
            <CardHeader>
              <Dice5 className="w-8 h-8 text-red-500 mb-2" />
              <CardTitle className="text-white">Rolador de Dados</CardTitle>
            </CardHeader>
            <CardContent className="text-slate-300">
              Animações, vibração háptica, overlay de resultado e histórico de rolagens. Rolagem secreta para Mestres.
            </CardContent>
          </Card>
        </div>
      </section>

      {/* Modules Section */}
      <section id="modules" className="container max-w-7xl mx-auto px-4 py-16">
        <h3 className="text-3xl font-bold text-white mb-12 text-center">Módulos Principais</h3>
        <div className="space-y-6">
          <div className="bg-slate-800 border border-slate-700 rounded-lg p-6 hover:border-red-500/50 transition">
            <div className="flex items-start gap-4">
              <div className="w-12 h-12 bg-red-500/20 rounded-lg flex items-center justify-center flex-shrink-0">
                <Gamepad2 className="w-6 h-6 text-red-400" />
              </div>
              <div>
                <h4 className="text-xl font-bold text-white mb-2">Ficha de Personagem D&D 5e</h4>
                <p className="text-slate-300">
                  Seções completas: Identidade, Atributos, Combate, Perícias, Magias, Equipamentos e Traços. 
                  Cálculos automáticos de bônus, modificadores e CD de magia. Persistência em Room Database.
                </p>
              </div>
            </div>
          </div>

          <div className="bg-slate-800 border border-slate-700 rounded-lg p-6 hover:border-red-500/50 transition">
            <div className="flex items-start gap-4">
              <div className="w-12 h-12 bg-red-500/20 rounded-lg flex items-center justify-center flex-shrink-0">
                <Volume2 className="w-6 h-6 text-red-400" />
              </div>
              <div>
                <h4 className="text-xl font-bold text-white mb-2">Soundboard de Ambientação</h4>
                <p className="text-slate-300">
                  8 sons de ambiente em loop (Taverna, Floresta, Masmorra, Batalha, Chuva, Oceano, Cidade Medieval, Caverna). 
                  Efeitos sonoros pontuais (Dado rolando, Nível up, Morte, Crítico). Controle de volume global.
                </p>
              </div>
            </div>
          </div>

          <div className="bg-slate-800 border border-slate-700 rounded-lg p-6 hover:border-red-500/50 transition">
            <div className="flex items-start gap-4">
              <div className="w-12 h-12 bg-red-500/20 rounded-lg flex items-center justify-center flex-shrink-0">
                <Users className="w-6 h-6 text-red-400" />
              </div>
              <div>
                <h4 className="text-xl font-bold text-white mb-2">Tracker de Iniciativa</h4>
                <p className="text-slate-300">
                  Timer de turno configurável (15s/30s/60s/sem limite). Destaque visual animado no personagem atual. 
                  Alerta sonoro e vibração ao esgotar o tempo.
                </p>
              </div>
            </div>
          </div>
        </div>
      </section>

      {/* Tech Stack */}
      <section className="container max-w-7xl mx-auto px-4 py-16">
        <h3 className="text-3xl font-bold text-white mb-12 text-center">Stack Tecnológico</h3>
        <div className="bg-slate-800 border border-slate-700 rounded-lg p-8">
          <div className="grid md:grid-cols-2 gap-8">
            <div>
              <h4 className="text-lg font-bold text-white mb-4">Frontend</h4>
              <ul className="space-y-2 text-slate-300">
                <li>✓ Kotlin</li>
                <li>✓ Android SDK 24+ (Android 7.0+)</li>
                <li>✓ XML Layouts com ConstraintLayout</li>
                <li>✓ Material Design 3</li>
              </ul>
            </div>
            <div>
              <h4 className="text-lg font-bold text-white mb-4">Arquitetura & Persistência</h4>
              <ul className="space-y-2 text-slate-300">
                <li>✓ MVVM + Repository Pattern</li>
                <li>✓ Room Database</li>
                <li>✓ SharedPreferences</li>
                <li>✓ Kotlin Coroutines</li>
              </ul>
            </div>
          </div>
          <div className="mt-8 pt-8 border-t border-slate-700">
            <h4 className="text-lg font-bold text-white mb-4">Integrações</h4>
            <ul className="grid md:grid-cols-2 gap-4 text-slate-300">
              <li>✓ Jitsi Meet SDK (Videochamada)</li>
              <li>✓ Canvas API (Mapa de Batalha)</li>
              <li>✓ MediaPlayer (Soundboard)</li>
              <li>✓ Firebase Realtime DB (Opcional)</li>
            </ul>
          </div>
        </div>
      </section>

      {/* Download Section */}
      <section id="download" className="container max-w-7xl mx-auto px-4 py-20">
        <div className="bg-gradient-to-r from-red-600 to-red-700 rounded-lg p-12 text-center">
          <h3 className="text-3xl font-bold text-white mb-4">Pronto para Começar?</h3>
          <p className="text-red-100 mb-8 text-lg">
            Baixe o código-fonte completo, README profissional e instruções de instalação.
          </p>
          <div className="flex flex-col sm:flex-row gap-4 justify-center">
            <Button size="lg" className="bg-white text-red-600 hover:bg-red-50">
              Download ZIP (37 KB)
            </Button>
            <Button size="lg" variant="outline" className="border-white text-white hover:bg-red-700">
              Ver no GitHub
            </Button>
          </div>
        </div>
      </section>

      {/* Footer */}
      <footer className="border-t border-slate-700 bg-slate-900 py-8">
        <div className="container max-w-7xl mx-auto px-4 text-center text-slate-400">
          <p>TavernCall 2.0 © 2026 • Projeto de Portfólio • Licença MIT</p>
        </div>
      </footer>
    </div>
  );
}
