# TavernCall 2.0

## 1. Nome, Versão e Proposta de Valor

**TavernCall 2.0** é a evolução definitiva para jogadores de RPG de mesa online. Esta aplicação Android unifica todas as ferramentas essenciais para uma sessão imersiva e sem interrupções, eliminando a necessidade de alternar entre múltiplos aplicativos. Com videochamada integrada via Jitsi Meet SDK e módulos avançados de Mapa de Batalha, Ficha de Personagem D&D 5e e Soundboard de ambientação, o TavernCall 2.0 oferece uma experiência completa e fluida para Mestres e jogadores.

## 2. Problema que Resolve

Atualmente, grupos de RPG online dependem de diversas ferramentas simultaneamente: uma para videochamada, outra para rolagem de dados, uma terceira para fichas de personagem, uma quarta para mapas de batalha e ainda outra para músicas de ambiente. Essa fragmentação gera atrito, distrai os jogadores e compromete a imersão. O TavernCall 2.0 resolve este problema ao consolidar todas essas funcionalidades em uma única interface Android, mantendo a videochamada Jitsi sempre visível enquanto as ferramentas ficam acessíveis em abas no painel inferior.

## 3. Lista Completa de Funcionalidades por Módulo

### Módulo Principal: Sessão Integrada
- **Videochamada Jitsi Meet**: Integrada diretamente na tela de sessão, ocupando 65% da altura, garantindo comunicação contínua.
- **Interface Unificada**: Ferramentas acessíveis via `TabLayout` na parte inferior da tela, permitindo troca rápida entre módulos.
- **Overlays Dinâmicos**: Exibição temporária de resultados de dados, condições de status e timer de turno sobre a videochamada.

### Módulo 1: Mapa de Batalha (Aba "Mapa")
- **`BattleMapView` Customizada**: Implementação de uma `View` personalizada utilizando a `Canvas` API para renderização.
- **Carregamento de Imagens**: Mestre pode carregar imagens de fundo do dispositivo ou via URL.
- **Tokens Arrastáveis**: Representações circulares de personagens e monstros com iniciais e cores distintas (Jogadores: azul, Monstros: vermelho, NPCs: verde).
- **Menu de Contexto para Tokens**: Toque longo em um token abre opções para Renomear, Mudar cor ou Remover.
- **Adição de Tokens**: Botão flutuante para adicionar novos tokens com nome e categoria.
- **Grade Opcional**: Overlay de grade quadrada semitransparente (48dp por célula) para auxiliar no posicionamento.
- **Zoom e Pan**: Funcionalidades de `pinch-to-zoom` e `pan` com dois dedos para navegação no mapa.
- **Persistência Local**: Estado do mapa (tokens e posições) salvo em `SharedPreferences` como JSON.

### Módulo 2: Ficha de Personagem D&D 5e Completa (Aba "Ficha")
- **Seções Detalhadas**: Abrange Identidade, Atributos Base, Combate, Perícias, Magias, Equipamentos/Inventário e Traços/Anotações.
- **Cálculos Automáticos**: Bônus de proficiência, modificadores de atributo, CD de magia e bônus de ataque de magia calculados automaticamente.
- **Barra de HP Visual**: Indicador de HP com cores dinâmicas (verde, amarelo, vermelho, cinza).
- **Gestão de Magias**: Toggle para conjuradores, seleção de atributo de conjuração, controle de espaços de magia por nível.
- **Inventário e Moedas**: Lista de itens com peso e categoria, cálculo de peso total e campos para moedas (PP, PO, PE, PA, PC).
- **Persistência Robusta**: Toda a ficha salva em `Room Database` com suporte a múltiplos personagens.

### Módulo 3: Soundboard de Ambientação (Aba "Som")
- **Sons de Ambiente em Loop**: 8 arquivos `.mp3` empacotados no APK (Taverna, Floresta, Masmorra, Batalha, Chuva, Oceano, Cidade Medieval, Caverna).
- **Interface Intuitiva**: Grid 2x4 de cards com ícone, nome e toggle on/off. Apenas um som ambiente ativo por vez.
- **Controle de Volume Global**: `SeekBar` para ajustar o volume de todos os sons.
- **Botão "Parar tudo"**: Interrompe qualquer som ambiente ativo.
- **Sons de Efeito Pontual (SFX)**: Botões dedicados para "Dado rolando", "Nível up!", "Morte" e "Crítico!" (não em loop).

### Módulo 4: Dados e Iniciativa (Aba "Dados" e "Iniciativa")
- **Rolador de Dados Aprimorado**: Animação de shake, vibração háptica e overlay de resultado sobre o JitsiMeetView por 3 segundos.
- **Rolagem Secreta**: Opção para o Mestre realizar rolagens que aparecem apenas localmente.
- **Histórico de Rolagens**: Armazena os últimos 20 resultados com timestamp.
- **Tracker de Iniciativa com Timer**: Contagem regressiva configurável (15s/30s/60s/sem limite) para turnos, visível como overlay circular.
- **Alertas de Timer**: Alerta sonoro e vibração ao esgotar o tempo.
- **Destaque Visual**: Borda pulsante em âmbar no personagem atual da lista de iniciativa.

## 4. Tecnologias Utilizadas

- **Linguagem**: Kotlin
- **Min SDK**: 24 (Android 7.0)
- **Jitsi Meet SDK**: Versão estável mais recente
- **UI**: XML Layouts com ConstraintLayout
- **Arquitetura**: MVVM + Repository Pattern
- **Persistência Local**: Room Database (fichas) + SharedPreferences (configurações)
- **Backend Opcional para Mapa**: Firebase Realtime Database (se implementado, caso contrário, local)
- **Mídia**: MediaPlayer para Soundboard
- **Gráficos**: Canvas API para Mapa de Batalha
- **Coroutines**: Kotlin Coroutines para operações assíncronas

## 5. Instruções de Instalação Passo a Passo

1.  **Clone o Repositório:**
    ```bash
    git clone [URL_DO_REPOSITORIO]
    cd TavernCall
    ```
2.  **Abra no Android Studio:**
    Abra o projeto `TavernCall` no Android Studio (versão Hedgehog ou mais recente).
3.  **Sincronize o Gradle:**
    Aguarde o Android Studio sincronizar automaticamente os arquivos Gradle e baixar as dependências. Certifique-se de que sua conexão com a internet esteja ativa.
4.  **Configure o Firebase (Opcional):**
    Se desejar utilizar o Firebase Realtime Database para o mapa, siga as instruções de configuração do Firebase para Android e adicione seu arquivo `google-services.json` ao diretório `app/`.
5.  **Execute o Aplicativo:**
    Conecte um dispositivo Android (com Android 7.0 ou superior) ou inicie um emulador. Clique no botão "Run" (ícone de play verde) no Android Studio para instalar e executar o aplicativo.

## 6. Fluxo de Uso

1.  **Criar/Selecionar Personagem**: Na tela inicial (Lobby), o usuário pode gerenciar suas fichas de personagem ou criar novas.
2.  **Iniciar Sessão**: Insira o nome da sala Jitsi e clique em "Entrar na Sessão".
3.  **Videochamada Ativa**: A videochamada Jitsi será iniciada e exibida na parte superior da tela.
4.  **Utilizar Ferramentas**: Acesse os módulos de Dados, Ficha de Personagem, Mapa de Batalha, Soundboard e Iniciativa através das abas na parte inferior da tela.
    - **Dados**: Role dados e visualize o histórico.
    - **Ficha**: Edite e consulte a ficha do seu personagem.
    - **Mapa**: Mova tokens, adicione novos e visualize a grade.
    - **Som**: Reproduza sons de ambiente e efeitos sonoros.
    - **Iniciativa**: Gerencie a ordem de turno e o timer.

## 7. Seção "Preview"

### QR Code

![QR Code Placeholder](https://via.placeholder.com/150?text=QR+Code+Aqui)

### URL da Manus AI

[URL de Preview da Manus AI](https://manus.im/preview/taverncall)

## 8. Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

```
MIT License

Copyright (c) [Ano] [Seu Nome ou Nome da Organização]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
