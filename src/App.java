
class App {
  public static void main(String[] args) {
    System.out.println("Olá mundo!");

    // para simplificação, apenas dois jogadores em cada equipe
    Jogador joao = new Jogador("Joao");
    Jogador jose = new Jogador("Jose");

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
    System.out.println(azul.getJogador(0) == null);

    azul.inscrever(joao);
    azul.inscrever(jose);

    System.out.println(azul.getNome().equals("Equipe Azul"));
    System.out.println(azul.getNumeroJogadores() == 2);
    System.out.println(azul.getJogador(0).equals(joao));
    System.out.println(azul.getJogador(1).equals(jose));
    System.out.println(azul.getJogador(2) == null);

    vermelha.inscrever(mario);
    vermelha.inscrever(marcelo);

    amarela.inscrever(pedro);
    amarela.inscrever(paulo);

    System.out.println(amarela.getJogador(0).equals(pedro));
    System.out.println(amarela.getJogador(1).equals(paulo));

    Torneio torneioObjetos = new Torneio("Torneio de Voleibol: Objetos!");

    // sem jogos, ainda
    System.out.println(torneioObjetos.getNome().equals("Torneio de Voleibol: Objetos!"));
    System.out.println(torneioObjetos.getNumeroJogos() == 0);
    System.out.println(torneioObjetos.getJogo(0) == null);
    System.out.println(torneioObjetos.getVencedor() == null);
    System.out.println(torneioObjetos.getJogoAtual() == null);

    torneioObjetos.inscrever(azul); // adicionando uma equipe ao torneio

    // com apenas uma equipe não há como construir jogos
    System.out.println(torneioObjetos.getNumeroEquipes() == 1);
    System.out.println(torneioObjetos.getNumeroJogos() == 0);
    System.out.println(torneioObjetos.getJogo(0) == null);
    System.out.println(torneioObjetos.getVencedor() == null);
    System.out.println(torneioObjetos.getJogoAtual() == null);

    torneioObjetos.inscrever(vermelha);

    // com a segunda equipe forma-se o primeiro jogo
    System.out.println(torneioObjetos.getNumeroEquipes() == 2);
    System.out.println(torneioObjetos.getNumeroJogos() == 1);
    System.out.println(torneioObjetos.getJogo(0) != null);
    System.out.println(torneioObjetos.getJogo(1) == null); // só tem um jogo
    System.out.println(torneioObjetos.getVencedor() == null);
    System.out.println(torneioObjetos.getJogoAtual() != null);

    // o jogo atual é sempre um jogo sem vencedor ainda
    System.out.println(torneioObjetos.getJogo(0) == torneioObjetos.getJogoAtual());

    // as primeiras equipes a se inscrever
    // têm prioridades como mandante
    System.out.println(torneioObjetos.getJogoAtual().getMandante() == azul);
    System.out.println(torneioObjetos.getJogoAtual().getVisitante() == vermelha);
    System.out.println(torneioObjetos.getJogoAtual().getSet(0) == null);
    System.out.println(torneioObjetos.getJogoAtual().getNumeroSets() == 0);
    System.out.println(torneioObjetos.getJogoAtual().getVencedor() == null);

    torneioObjetos.inscrever(amarela);

    // com 3 equipes forma-se 3 jogos, com 4 formariam-se 6 partidas
    // que é o caso de todos contra todos: combinacao(m,p) = fat(m) / fat(m-p) *
    // fat(p)
    System.out.println(torneioObjetos.getNumeroJogos() == 3);
    System.out.println(torneioObjetos.getJogo(0) != null);
    System.out.println(torneioObjetos.getJogo(1) != null);
    System.out.println(torneioObjetos.getJogo(2) != null);
    System.out.println(torneioObjetos.getJogo(3) == null);
    System.out.println(torneioObjetos.getVencedor() == null);
    System.out.println(torneioObjetos.getJogoAtual() != null);

    // O jogo atual é o primeiro jogo
    System.out.println(torneioObjetos.getJogoAtual() == torneioObjetos.getJogo(0));

    Jogo segundoJogo = torneioObjetos.getJogo(1);

    System.out.println(segundoJogo.getMandante() == azul);
    System.out.println(segundoJogo.getVisitante() == amarela);

    // lembrando: quem se inscreve primeiro tem
    // prioridade como mandante
    System.out.println(torneioObjetos.getJogo(2).getMandante() == vermelha);
    System.out.println(torneioObjetos.getJogo(2).getVisitante() == amarela);

    // a interação do jogo é obtida pelo Jogo Atual fechando os sets
    Set setFechado = torneioObjetos.getJogoAtual().fecharSet(25, 19);

    System.out.println(torneioObjetos.getJogoAtual().getVencedor() == null);
    System.out.println(torneioObjetos.getJogoAtual().getNumeroSets() == 1);
    System.out.println(torneioObjetos.getJogoAtual().getSet(0) != null);
    System.out.println(torneioObjetos.getJogoAtual().getSet(0) == setFechado);
    System.out.println(torneioObjetos.getJogoAtual().getSet(0).getPontosMandante() == 25);
    System.out.println(torneioObjetos.getJogoAtual().getSet(0).getPontosVisitante() == 19);
    System.out.println(setFechado.getPontosMandante() == 25);
    System.out.println(setFechado.getPontosVisitante() == 19);

    // O segundo set não foi fechado, então não existe ainda
    System.out.println(torneioObjetos.getJogoAtual().getSet(1) == null);

    // necessário fechar pelo menos três sets
    // para ter um vencedor, podendo ser quatro ou cinco
    // até uma das equipes alcançar três 25 pontos (vamos ignorar o empate)
    torneioObjetos.getJogoAtual().fecharSet(25, 12);

    System.out.println(torneioObjetos.getJogoAtual().getSet(1) != null); // há um segundo set
    // terceiro e último set
    System.out.println(torneioObjetos.getJogoAtual().getSet(2) == null);
    torneioObjetos.getJogoAtual().fecharSet(25, 20);
    System.out.println(torneioObjetos.getJogoAtual().getSet(2) != null); // há um terceiro set

    // após três sets ganhos os sets não são mais fechados
    torneioObjetos.getJogo(0).fecharSet(25, 15); // sem efeito, o primeiro jogo já teve vencedor
    System.out.println(torneioObjetos.getJogo(0).getNumeroSets() == 3);
    System.out.println(torneioObjetos.getJogo(0).getVencedor() == azul);

    // havendo um vencedor o Jogo Atual passa a ser o próximo, por isso o efeito a seguir:
    System.out.println(torneioObjetos.getJogoAtual() == segundoJogo);
    System.out.println(segundoJogo.getVencedor() == null);
    System.out.println(segundoJogo.getNumeroSets() == 0);

    // para ver o jogo passado acesse pelo numero, neste caso o primeiro jogo é o jogo 0:
    System.out.println(torneioObjetos.getJogo(0).getVencedor() == azul);
    System.out.println(torneioObjetos.getJogo(0).getNumeroSets() == 3);
    System.out.println(torneioObjetos.getJogo(0).getSet(2) != null);
    System.out.println(torneioObjetos.getJogo(0).getSet(2).getPontosMandante() == 25);
    System.out.println(torneioObjetos.getJogo(0).getSet(2).getPontosVisitante() == 20);

    // fechando o segundo jogo, 3 para o mandante e 2 para o visitante:
    Set primeiroSet = segundoJogo.fecharSet(25, 9);
    Set segundoSet  = segundoJogo.fecharSet(25, 11);
    Set terceiroSet = segundoJogo.fecharSet(20, 25);
    Set quartoSet   = segundoJogo.fecharSet(22, 25);
    Set quintoSet   = segundoJogo.fecharSet(25, 13);

    System.out.println(segundoJogo.getVencedor() == azul);
    System.out.println(segundoJogo.getNumeroSets() == 5);
    System.out.println(segundoJogo.getSet(3) != null); // há um quarto set
    System.out.println(segundoJogo.getSet(3) == quartoSet); // há um quarto set
    System.out.println(quartoSet.getPontosMandante() == 22);
    System.out.println(quartoSet.getPontosVisitante() == 25);

    // abriu o terceiro e último jogo
    System.out.println(torneioObjetos.getJogoAtual() == torneioObjetos.getJogo(2));
    System.out.println(torneioObjetos.getJogoAtual().getVencedor() == null);

    // o torneio não tem vencedor até todos os jogos terem um vencedor
    System.out.println(torneioObjetos.getVencedor() == null);

    // fechando o terceiro jogo
    torneioObjetos.getJogoAtual().fecharSet(25, 19);
    torneioObjetos.getJogoAtual().fecharSet(25, 21);
    torneioObjetos.getJogoAtual().fecharSet(25, 23);

    // neste instante não há mais jogo atual - acabou o torneio
    System.out.println(torneioObjetos.getJogoAtual() == null);

    // consultando o último jogo
    System.out.println(torneioObjetos.getJogo(2).getVencedor() == vermelha);
    System.out.println(torneioObjetos.getJogo(2).getNumeroSets() == 3);
    System.out.println(torneioObjetos.getJogo(2).getSet(2) != null);
    System.out.println(torneioObjetos.getJogo(2).getSet(2).getPontosMandante() == 25);
    System.out.println(torneioObjetos.getJogo(2).getSet(2).getPontosVisitante() == 23);

    // checando o vencedor do torneio
    System.out.println(torneioObjetos.getVencedor() == azul);
    Equipe vencedor = torneioObjetos.getVencedor();
    System.out.println(vencedor.getJogador(0) == joao);
    System.out.println(vencedor.getJogador(1) == jose);


    // NOVO TORNEIO


    // Marcelo joga pela Amarela e Vermelha
    amarela.inscrever(marcelo);
    System.out.println(amarela.getNome().equals("Equipe Amarela"));
    System.out.println(amarela.getNumeroJogadores() == 3);
    System.out.println(amarela.getJogador(2) == marcelo);

    System.out.println(vermelha.getNome().equals("Equipe Vermelha"));
    System.out.println(vermelha.getNumeroJogadores() == 2);
    System.out.println(vermelha.getJogador(0).equals(mario));
    System.out.println(vermelha.getJogador(1).equals(marcelo));

    System.out.println(amarela.getJogador(2) == vermelha.getJogador(1));

    // Sem problema, se fossem torneios diferentes, mas
    // no mesmo torneio o mesmo jogador não pode estar em
    // duas equipes.

    Torneio torneioDois = new Torneio("Torneio Dois");

    torneioDois.inscrever(azul); // adicionando uma equipe ao torneio
    torneioDois.inscrever(vermelha); // adicionando uma equipe ao torneio

    // opa!
    try {
      // Não pode inscrever a amarela porque tem jogador compartilhado com outras equipes
      torneioDois.inscrever(amarela);
      System.out.println(false);
    } catch (Exception e) {
      System.out.println(true + " jogador Marcelo já está na equipe Vermelha");
    }

  }
}
