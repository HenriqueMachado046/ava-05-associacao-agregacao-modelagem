# Template de Projetos Java sem Maven/Gradle configurados para o Visual Studio Code

Um _template_ é um projeto modelo para não iniciar do zero e ter pelo menos uma estrutura básica onde se apoiar.

Antes de começar a desenvolver com este _template_ é necessário ter instalado o Java Software Development Kit (JDK), o editor Visual Studio Code (VSCode) e o utilitário de controle de versão de código _Git_.

## Instalação e Configuração do JDK

É necessário instalar o JDK a partir da versão 8, porém é recomendada versão 11-LTS (Long Term Support - suporte de longo prazo).

Para o Sistema Operacional (SO) Windows, ele pode ser obtido aqui <https://adoptopenjdk.net/>. Siga as instruções de instalação e não esqueça de selecionar os opcionais durante o processo, especialmente o _add Java to PATH_.

Para SO's baseados em Linux/Debian, como Ubuntu, Pop OS, Mint, Elementary, execute no terminal o comando `sudo apt install openjdk-11-jdk`.

Para testar a instalação, seja no Windows ou Linux, abra o _Prompt_ de comando ou o Terminal e execute o compilador Java com `javac -version`. A saída deve ser algo com `javac 11.0.9.1`, ou outra versão.

## Instalação e Configuração do Visual Studio Code (VSCode)

O VSCode pode ser obtido aqui: <https://code.visualstudio.com/download>. A instalação é semelhante no Sistemas Operacionais Windows e Linux.

No Windows, abra o instalador e não esqueça de selecionar todos os opcionais, como _adicionar code ao path_, _adicionar "abrir com code" ao menu_, etc.

No Linux, abra o arquivo `.deb` baixado no gerenciador de pacotes e instale normalmente conforme instruções de seu sistema operacional.

Este _template_ possui uma pasta [.vscode](.vscode) com as extensões necessárias em [extensions.json](.vscode/extensions.json) e as configurações recomendadas em [settings.json](.vscode/settings.json). **Fique a vontade para alterá-los como achar melhor.**

A única extensão obrigatória é a _"vscjava.vscode-java-pack"_.

A extensão _"EditorConfig"_ é bastante recomendada. Ela funciona junto com o arquivo [.editorconfig](.editorconfig) presente neste _template_ para padronizar a formatação dos códigos-fonte.

Finalmente, se preferes o editor em Português, instale a seguinte extensão: _Portuguese (Brazil) Language Pack for Visual Studio Code_.

## Instalação e Configuração do Git

O Git pode ser obtido para Windows neste link: <https://git-scm.com/download/win>. A instalação é simples, como sempre não esqueça dos opcionais, principalmente a opção _adicionar o git ao path_.

Para Linux/Debian/Ubuntu e derivados o comando `sudo apt install git` faz tudo.

Para verificar a instalação abra o _prompt_ ou um terminal e execute `git --version`. Se não acusou _comando não encontrado_ é porque está tudo funcionando perfeitamente.

## Executando

Com tudo isto pronto deve ser possível abrir o arquivo [App.java](src/App.java) e clicar em `run` para executar o projeto. Se quiser fazê-lo manualmente, abra um terminal no Linux ou _prompt_ de comando no Windows, e na pasta raiz do projeto execute `javac -cp bin -d bin src/App.java; java -cp bin App`.

## Testagem

O repositório está configurado para usar o JUnit como _framework_ para testagem (Testes Unitários). As bibliotecas estão disponíveis na pasta [lib](lib/).

Para executar os testes, abra o diretório [test](src/test/) e o teste que deseja executar, por exemplo [Testar](test/Testar.java). Clique em _run test_ e acompanhe os testes pela _sidebar_, ícone testes, logo abaixo de extensões.

## Code Conventions | Style Guide Checking

O repositório foi configurado para usar o [**CheckStyle**](https://checkstyle.sourceforge.io/) que é um _plugin_ para verificar a indentação, aparência do código e padrões de nomeação e organização, junto com uma [extensão do VSCode](https://marketplace.visualstudio.com/items?itemName=shengchen.vscode-checkstyle) para habilitá-lo.

O padrão usado é o [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html) disponível em <https://google.github.io/styleguide/javaguide.html>.

Portanto, códigos desalinhados e/ou em desacordo com estas regras de formação aparecerão com um sublinhado amarelo conhecido como _warning_ (não é um erro, é uma recomendação).
