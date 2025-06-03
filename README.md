
<img src="https://github.com/user-attachments/assets/b95f2bea-cb78-4213-8cae-40a622619705" alt="Logo" width="120" height="120">

# Movies Now

**Movies Now** é um aplicativo de lista de filmes populares. Ao tocar em um dos filmes, você poderá ver mais detalhes interessantes sobre ele.

Totalmente desenvolvido em **Kotlin Multiplatform**, com a lógica e requisição dos dados feitas em Kotlin, as telas Android com Jetpack Compose e as telas iOS com SwiftUI.

https://github.com/user-attachments/assets/488f0746-73c7-4f8c-ad4d-cfe33124008c

## Como Rodar

É possível rodar o projeto clonando-o e utilizando as IDEs: Android Studio para Android e Xcode para iOS.

Além disso, disponibilizarei um **APK para teste mais direto**, sendo assim possível somente baixar o arquivo e instalar em um dispositivo Android.

[APK para Download](https://github.com/LucasDSantosF/Movies-Now/tree/main/APK)


## Estrutura e Decisões Técnicas

A arquitetura adotada foi a **MVVM**, que é a arquitetura padrão ao criar um projeto KMP e também a que possuo mais domínio, já tendo trabalhado profissionalmente com ela por mais de 3 anos.

Para a requisição de dados, foi utilizada a biblioteca **Apollo**, que é a mais comum e confiável para trabalhar com GraphQL.

A **Injeção de Dependência** foi implementada com a biblioteca **Koin**, super confiável para trabalhar em projetos KMP, além de ser bem prática de se implementar.

A biblioteca **Coil** foi utilizada para auxiliar na renderização de imagens a partir de URLs, e a **AndroidYoutubePlayer** para a renderização de vídeos do YouTube com a URL.

Além dessas, outras bibliotecas que já estavam implementadas, como AndroidX e Compose BOM, me auxiliaram durante o desenvolvimento do aplicativo.

## Ressalvas

Infelizmente, não consegui testar meu código no iOS porque não tive acesso a um macOS a tempo. No entanto, tenho certeza de que é possível verificar minhas competências através do código escrito.
Infelizmente também não consegui criar testes unitário e de Ui a tempo, porem tenho outro projeto que no meu GitHub chamado Pokedex que mostram com clareza minha minhas competências em testes.
