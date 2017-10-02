# ufjf-dcc171-2017-3-trb1-mateusgon
ufjf-dcc171-2017-3-trb1-mateusgon created by GitHub Classroom

<h2> - Identificação do Aluno </h2>

Nome: Mateus Gonçalo do Nascimento.

Matrícula: 201576003.

Curso: Sistemas de Informação.

<h2> - Cenário do Sistema </h2>

<p1> Pizzaria Petini, como o próprio nome diz, é a novidade na cidade de Petrópolis, Rio de Janeiro. 
Com o surgimento da pizzaria, a necessidade de um software para auxilar no gerenciamento da mesma
passar a ficar evidente e ser necessário. Petini é um local onde as pessoas podem se encontrar para comer uma pizza, tomar
um refrigerante e acima de tudo, poder provar as delícias que a casa tem pra oferecer.</p1>

<p1> O software que será descrito aqui possui as seguintes características para facilitar sua utilização: </br>
- Possibilidade de controle dos itens, informando seus valores e nomes. </br>
- Possibilidade de controle do funcionamento do restaurantes, oferecendo controle de mesas e pedidos. </br>
- O controle dos itens permite ao usuário: Adicionar, Alterar ou Remover um item. </br>
- O controle do funcionamento permite ao usuário: Adicionar Mesa, Remover Mesa, Realizar um pedido, 
Excluir um pedido feito de forma errada, Ver o Cardápio com todos os itens, Ver um Pedido que está aberto ou fechado e seus respectivos itens, 
O total faturado durante o funcionamento do software e, por fim, Fechar a Conta de uma mesa. </br>
</p1>

<p1> O software para a Petini, então, oferece um serviço completo para auxiliar os serviços administrativos que são distribuídos na pizzaria, desde a administração dos pedidos, seus itens e os valores os quais estarão envolvidos com os pedidos realizados pelos clientes. </p1>

<h2> - Modelo de Dados </h2> 

<h2> - Campos necessários para a construção das telas </h2>

<h2> - Pontos importantes da interface </h2>

<p1> A interface gráfica, inicialmente, foi dividida em duas partes, a parte de administração dos itens e administração do funcionamento. Quando iniciado, o software possui dois botões, o primeiro botão se refere a administração dos itens e o segundo a administração do funcionamento. </br>

Na parte de administração dos itens, o usuário terá uma nova janela e um combo box e ele poderá adicionar um novo item, onde informará o nome e uma pequena descrição do item, após irá escolher a que tipo de item pertecente, e por fim, a pessoa irá informar o valor. Na parte de alterar um item, o usuário irá ver uma lista e deverá escolher um item para alterar e selecionar o botão alterar. Uma nova janela será aberta e ele modificará o item como se estivesse criando um novo. Por fim, o usuário poderá excluir um item específico, cabe a ele selecionar o item e apertar excluir. </br>

Na parte de administração do funcionamento, uma nova janela surgirá e um usuário pode adicionar uma mesa, a qual terá seu número atribuído automaticamente, poderá excluir uma mesa só a selecionando. O usuário também poderá realizar um pedido, onde uma nova janela irá surgir e o usuário deverá selecionar o tipo de item que ele quer, e digitar o número que ele deseja de um determinado item e por fim apertar confirma. Um usuário também pode excluir um pedido que ele criou. Ele também poderá ver o cardápio que abrirá uma nova janela com um combo box. Ver pedido, mais uma funcionalidade, abrirá uma nova janela, onde ele poderá ver a hora que o pedido foi aberto, a hora que foi fechado, se já estiver fechado, os itens de um pedido e a quantidade. O total faturado exibirá o valor total recebido em um JOptionPane e o Fechar Conta, funciona como um fechar pedido, onde o usuário poderá encerrar um pedido. Ele seleciona a mesa e o pedido desejado, e aperta fechar conta e uma nova janela é aberta. Ele irá ver as informações como em Ver Pedido, de forma bastante semelhante.

<h2> - Maiores dificuldades de implementação </h2> 

<p1> Na minha opinião, grandes dificuldades foram encontradas no que diz respeito a se trabalhar com várias janelas e a forma como elas se comunicam. Por exemplo, quando uma janela é fechada, o que a outra realiza. Outro fator que me chamou atenção foi a dificuldade em somente possuir uma janela aberta, e não várias simultaneamente. </br>

Uma outra grande dificuldade foi no quesito de como apresentar uma bela interface com boas funcionalidades. Isso aconteceu pois a formatação da tela não foi uma tarefa fácil, algumas dificuldades com o tamanho da tela, o JScrollPane foram encontradas, pois nem sempre o que era esperado era realizado seja pelo JScrollPane ou mesmo o tamanho da tela. Em alguns casos, o JScrollPane ficava limitado pelo vertical box e não era simples modificá-lo. </br>

Creio que no geral a maior dificuldade foi na formatação da tela para o cliente e o usuário possuírem uma boa visualização do produto e tratar possíveis erros que poderiam acontecer, erros muitas vezes causados pelo usuário. Esses erros foram difíceis de tratar na hora de um usuário criar um novo item e alterá-lo, onde inserções devem ser feitas e um usuário pode cadastrar um item de forma errada. </p1>

<h2> - Melhorias futuras </h2> 

<p1> Melhorias futuras podem ocorrer com a utilização de um banco de dados, onde controlar a quantidade de itens disponíveis
pode se apresentar como uma boa solução. Além disso, a utilização do Banco de Dados pode oferecer ao sistema um maior controle e administração dos dados através de novas funcionalidades que possam surgir para melhorar o funcionamento do softare. </br>

Outra melhoria futura que pode vir a ser interessante seria a possibilidade de alterar um pedido o qual já foi realizado, dessa maneira, não seria necessária a exclusão do mesmo para depois realizá-lo novamente. Poderia haver um controle maior também sobre o número dos pedidos, podendo ser reiniciada a contagem de acordo com a vontade do cliente. Outra mudança interessante se trata da possibilidade de poder realizar a descrição dos itens, sobre a forma de preparação para pessoas que possam vir a ter problemas com ingredientes. No "Total faturado", uma boa melhoria futura seria mostrar a quantidade de itens que foram consumidos, para saber quais itens atraem mais os clientes e são vendidos. </br>

Na questão de tratamento de erros, poderá ser pensado em como tratar erros que podem surgir na hora de adicionar um item ou alterá-lo. Mais uma melhora seria no quesito de tipo do item, onde uma boa melhoria seria o usuário poder criar novos tipos além dos existentes: pizzas salgadas, pizzas doces, refrigerantes e sobremesas. </br>

Na questão de interface gráfica, uma maior adaptabilidade da tela a diferentes monitores poderia ser uma boa melhoria futura. O tratamento de erros e a abertura de diversas janelas simultâneas também podem ser melhores trabalhadas no quesito de serem mais fáceis quando um botão é apertado, por exemplo, quando confirmado o pedido, a janela fechar no exato momento. Além do que já foi citado, uma melhoria do aspecto de beleza poderia ser realizado futuramente também. </p1>
