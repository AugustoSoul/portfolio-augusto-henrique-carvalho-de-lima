# ⚔️ Batalha de Modelos & Engenharia de Prompt (XML)

<img src="https://img.shields.io/badge/Status-Concluído-green?style=for-the-badge">
<img src="https://img.shields.io/badge/Tema-Engenharia%20de%20Prompt-purple?style=for-the-badge">
<img src="https://img.shields.io/badge/Formato-XML-orange?style=for-the-badge">

## 👥 Equipe

| Nome |
| :--- |
| Gabriel de Assis Silva |
| Augusto Henrique Carvalho De Lima |
| Pedro Straub Mantoan |

## 📝 Descrição do Projeto

Este projeto consiste na construção de um **Prompt Estruturado em XML** para gerar uma página HTML Single Page com CSS integrado, testado em **7 ferramentas de IA diferentes** para análise comparativa de desempenho.

## 🧪 Prompt Estruturado em XML

```xml
<tarefa>
  <objetivo>Criar uma página HTML5 única com CSS3 interno (single page).</objetivo>
  <tema>Ginástica</tema>
  <diretrizes_design>
    <layout>Responsivo e minimalista.</layout>
    <paleta_cores>Verde, Preto</paleta_cores>
    <tipografia>Sans-serif para títulos, Serif para corpo.</tipografia>
  </diretrizes_design>
  <obrigatoriedades_tecnicas>
    <item>Menu de navegação funcional (âncoras).</item>
    <item>Seção de portfólio ou galeria.</item>
    <item>Rodapé com informações de contato simuladas.</item>
    <item>Integração de acessibilidade (libras)</item>
  </obrigatoriedades_tecnicas>
  <metrica_obrigatoria>
    Ao final da resposta, informe uma estimativa de quantos tokens foram gerados para este código.
  </metrica_obrigatoria>
</tarefa>
```

## 📊 Quadro de Análise Comparativa

| Critério | GPT | Gemini | DeepSeek | Qwen | Grok | Maritaca | Claude |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| **Precisão do prompt** | 6/10 | 7/10 | 6/10 | 8/10 | 5/10 | 1/10 | 5/10 |
| **Precisão do HTML** | 7/10 | 7/10 | 9/10 | 4/10 | 6/10 | 2/10 | 9/10 |
| **Criatividade no Conteúdo** | 2/10 | 5/10 | 8/10 | 5/10 | 7/10 | 1/10 | 9/10 |
| **Erros de Sintaxe (Bugs)** | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
| **Tokens Gastos** | ~1.150–1.350 | ~1.050 | ~1.750–1.950 | ~1.900–2.100 | ~4.850 | ~1.050 | ~3.800–4.200 |

## 💬 Reflexão Crítica

**1. Qual modelo demonstrou maior "compreensão" da estrutura do prompt em XML?**
> Claude conseguiu seguir de boa parte o pedido do prompt em XML, mas Qwen, Gemini e ChatGPT foram os únicos que adicionaram acessibilidade (libras) funcional.

**2. Houve diferença significativa na verbosidade (tokens) entre as IAs para o mesmo resultado?**
> Sim. Algumas IAs utilizaram 200% mais tokens do que as mais econômicas (1.050 tokens). Grok foi o mais verboso com ~4.850 tokens, enquanto Gemini e Maritaca foram os mais econômicos com ~1.050 tokens.

**3. Qual ferramenta escolheria para prototipagem rápida e qual para códigos mais complexos?**
> Para **códigos mais complexos**: Claude. Para **prototipagem rápida**: DeepSeek e Gemini são opções válidas.

## 📁 Arquivos do Projeto

| Arquivo | Descrição |
| :--- | :--- |
| [Experiência_3_-_Batalha_de_Modelos.docx](./Experiência_3_-_Batalha_de_Modelos.docx) | Documento completo com análise comparativa |

---
Desenvolvido por <a href="https://github.com/AugustoSoul">AugustoSoul</a> e equipe
