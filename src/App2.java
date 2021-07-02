
class App2 { // ESTA É A VERSÃO READEQUADA PARA A 5TA SEMANA, FAÇA ESTA
  public static void main(String[] args) {
    System.out.println("Olá mundo!");

    // PARA SIMPLIFICAÇÃO, APENAS DOIS JOGADORES EM CADA EQUIPE
    Jogador joao    = new Jogador("Joao");
    Jogador jose    = new Jogador("Jose");

    System.out.println(joao.getNome().equals("Joao"));
    System.out.println(jose.getNome().equals("Jose"));

    Jogador mario   = new Jogador("Mario");
    Jogador marcelo = new Jogador("Marcelo");

    Jogador pedro   = new Jogador("Pedro");
    Jogador paulo   = new Jogador("Paulo");

    Equipe azul     = new Equipe("Equipe Azul");
    Equipe vermelha = new Equipe("Equipe Vermelha");
    Equipe amarela  = new Equipe("Equipe Amarela");

    System.out.println(azul.getNome().equals("Equipe Azul"));
    System.out.println(azul.getNumeroJogadores() == 0);
    System.out.println(azul.getJogador(1) == null);

    azul.inscrever(joao);
    azul.inscrever(jose);

    System.out.println(azul.getNome().equals("Equipe Azul"));
    System.out.println(azul.getNumeroJogadores() == 2);
    System.out.println(azul.getJogador(1).equals(joao));
    System.out.println(azul.getJogador(2).equals(jose));
    System.out.println(azul.getJogador(3) == null);

    vermelha.inscrever(mario);
    vermelha.inscrever(marcelo);

    amarela.inscrever(pedro);
    amarela.inscrever(paulo);

    System.out.println(amarela.getJogador(1).equals(pedro));
    System.out.println(amarela.getJogador(2).equals(paulo));

    Torneio torneio = new Torneio("Torneio de Voleibol: Objetos!");

    // SEM JOGOS, AINDA
    System.out.println(torneio.getNome().equals("Torneio de Voleibol: Objetos!"));
    System.out.println(torneio.getNumeroJogos()     == 0);
    System.out.println(torneio.getJogo(1)           == null);
    System.out.println(torneio.getVencedorTorneio() == null);

    torneio.inscrever(azul); // ADICIONANDO UMA EQUIPE AO TORNEIO

    // COM APENAS UMA EQUIPE NÃO HÁ COMO CONSTRUIR JOGOS
    System.out.println(torneio.getNumeroEquipes()   == 1);
    System.out.println(torneio.getNumeroJogos()     == 0);
    System.out.println(torneio.getJogo(1)           == null);
    System.out.println(torneio.getVencedorTorneio() == null);

    torneio.inscrever(vermelha); // ADICIONANDO OUTRA EQUIPE AO TORNEIO

    // COM A SEGUNDA EQUIPE FORMA-SE O PRIMEIRO JOGO
    System.out.println(torneio.getNumeroEquipes()   == 2);
    System.out.println(torneio.getNumeroJogos()     == 1);
    System.out.println(torneio.getJogo(1)           != null); // SÓ TEM UM JOGO
    System.out.println(torneio.getJogo(2)           == null); // NÃO HÁ SEGUNDO JOGO
    System.out.println(torneio.getVencedorTorneio() == null);

    Jogo jogo = torneio.getJogo(1); // OBTENDO O JOGO 1

    // AS PRIMEIRAS EQUIPES A SE INSCREVER TÊM PRIORIDADES COMO MANDANTE
    System.out.println(jogo.getMandante()     == azul);
    System.out.println(jogo.getVisitante()    == vermelha);
    System.out.println(jogo.getVencedorJogo() == null);

    torneio.inscrever(amarela); // INSCREVENDO A TERCEIRA EQUIPE E ÚLTIMA EQUIPE

    // COM 3 EQUIPES FORMA-SE 3 JOGOS, SE FOSSEM 4 EQUIPES FORMARIAM-SE 6 PARTIDAS
    // QUE É O CASO DE TODOS CONTRA TODOS SEM JOGO DE VOLTA
    System.out.println(torneio.getNumeroJogos()     == 3);
    System.out.println(torneio.getJogo(1)           != null); // HÁ JOGO 1
    System.out.println(torneio.getJogo(2)           != null); // HÁ JOGO 2
    System.out.println(torneio.getJogo(3)           != null); // HÁ JOGO 3
    System.out.println(torneio.getJogo(4)           == null); // NÃO HÁ QUARTO JOGO
    System.out.println(torneio.getVencedorTorneio() == null); // NÃO HÁ VENCEDOR TORNEIO

    // OBTENDO TODOS OS JOGOS
    Jogo primeiroJogo = torneio.getJogo(1);
    Jogo segundoJogo  = torneio.getJogo(2);
    Jogo terceiroJogo = torneio.getJogo(3);

    // LEMBRANDO: QUEM SE INSCREVE PRIMEIRO TEM PRIORIDADE COMO MANDANTE
    System.out.println(primeiroJogo.getMandante()  == azul);
    System.out.println(primeiroJogo.getVisitante() == vermelha);
    System.out.println(segundoJogo.getMandante()   == azul);
    System.out.println(segundoJogo.getVisitante()  == amarela);
    System.out.println(terceiroJogo.getMandante()  == vermelha);
    System.out.println(terceiroJogo.getVisitante() == amarela);

    // PRECISA FECHAR PELO MENOS TRÊS SETS PARA O JOGO TER UM VENCEDOR
    System.out.println(primeiroJogo.getVencedorSet(1) == null);
    primeiroJogo.fecharSet(25, 19); // 25 PARA MANDANTE E 19 PONTOS PARA VISITANTE
    System.out.println(primeiroJogo.getVencedorSet(1).equals(azul));
    System.out.println(primeiroJogo.getVencedorSet(2) == null);
    System.out.println(primeiroJogo.getVencedorSet(3) == null);
    // NÃO HÁ VENCEDOR DO JOGO AINDA, APENAS APÓS UMA EQUIPE GANHAR TRÊS SETS
    System.out.println(primeiroJogo.getVencedorJogo() == null);
    primeiroJogo.fecharSet(12, 25); // 12 PARA MANDANTE E 25 PONTOS PARA VISITANTE
    System.out.println(primeiroJogo.getVencedorSet(2).equals(vermelha));
    primeiroJogo.fecharSet(25, 20); // 25 PARA MANDANTE E 20 PONTOS PARA VISITANTE
    System.out.println(primeiroJogo.getVencedorSet(3).equals(azul));
    // ESTÁ 2 A 1 PARA A EQUIPE AZUL
    System.out.println(primeiroJogo.getVencedorJogo() == null);
    primeiroJogo.fecharSet(25, 22); // 25 PARA MANDANTE E 22 PONTOS PARA VISITANTE
    System.out.println(primeiroJogo.getVencedorSet(4).equals(azul));
    // 3 A 1 PARA A MANDANTE DO PRIMEIRO JOGO QUE É A EQUIPE AZUL
    System.out.println(primeiroJogo.getVencedorJogo().equals(azul));

    // MAS NÃO HÁ VENCEDOR DO TORNEIO AINDA, SÓ DEPOIS DE HAVEREM VENCEDORES NOS
    // TRÊS JOGOS
    System.out.println(torneio.getVencedorTorneio() == null);

    // ENTÃO, FECHE OS SETS DO SEGUNDO E TERCEIRO JOGOS A SEGUIR DE MODO QUE TENHAM UM
    // VENCEDOR E LOGO O TORNEIO TENHA UM VENCEDOR A TUA ESCOLHA

    // E O VENCEDOR É:
    System.out.println(torneio.getVencedorTorneio().equals(TUA_ESCOLHA));
  }
}
