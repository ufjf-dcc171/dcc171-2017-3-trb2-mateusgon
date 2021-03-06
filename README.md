
<h1> - Identificação do Aluno </h1>

Nome: Mateus Gonçalo do Nascimento.

Matrícula: 201576003.

Curso: Sistemas de Informação.

<h1> Parte 2 - Persistência dos Dados Pizzaria </h1>

<h2> - Protocolo de Persistência Desenvolvido </h2>

<p1> Para resolver a persistência dos dados do trabalho foram adicionadas 6 classes. Sendo que para realizar a escrita dos dados serão trabalhados dois arquivos, são eles: "item.txt" e "funcionamento.txt". </p1>

<p1> Existe uma classe chamada de Pizzaria, a qual é responsável por gerenciar todos os dados importantes para o funcionamento das janelas e da Pizzaria. A classe Pizzaria é responsável por criar o MesasDAO, PedidoDAO, ItemDoPedidoDAO e ItemDAO. Além disso, trabalha também com o SampleDataItem (o que é o responsável por gerenciar os itens oferecidos pela pizzaria durante o funcionamento), um contador de pedidos, um contador de mesas e, por fim, a classe Diretório (será detalhada abaixo). </p1>

<p1> Quando iniciado o sistema, a classe Pizzaria é instanciada na classe JanelaPrincipal. A partir de sua instanciação, ela instancia também a classe Diretório e a classe SampleDataItem. No caso da classe diretório, ela verifica se os arquivos "item.txt" e "funcionamento.txt" já existem, caso positivo, os arquivos não são criados. Se já existirem, os arquivos são mantidos e passam a ser utilziados pelas outras classes para serem inicializadas com os dados do último funcionamento. Para a classe SampleDataItem é passado a instância de ItemDAO e o último é utilizado para fazer a leitura do arquivo "item.txt", o qual contêm todos os itens de funcionamento da pizzaria, como nome do item, tipo do item e o seu valor. </p1>

<p1> No construtor da classe Pizzaria existe o método ler(), o qual faz uma chamada para a classe MesasDAO passando por parâmetro uma instância de PedidoDAO e ItemDoPedidoDAO. A classe MesasDAO lê cada mesa, chamando a classe PedidoDAO para ler os pedidos de cada mesa, passando por parâmetro uma instância de ItemDoPedidoDAO. Por fim, a classe PedidoDAO chama a classe ItemDoPedidoDAO, para que os itens de cada pedido possam ser lidos do arquivo. Todas essas classes trabalham com o documento "funcionamento.txt". Após a leitura de todos os dados, a classe MesasDAO possui um ArrayList com todas as mesas, as quais contêm seus pedidos e seus itens dos pedidos. Esse ArrayList é retornado para a classe Pizzaria, a qual possui o controle dos dados, agora, dos dados de funcionamento da pizzaria </p1>

<p1> Quando é necessária uma modificação do arquivo "item.txt" ou "funcionamento.txt", dois métodos da classe Pizzaria podem ser chamados. No caso de itens, o método atualizarItem() é utilizado. Ele utiliza a instância de SampleDataItem, a qual chama a classe atualiza(), e lá a classe de ItemDAO é utilizada e ele atualiza os dados do arquivo "item.txt". A atualização é feita seja por adição, alteração ou exclusão de um item. No caso de funcionamento, a classe Pizzaria possui o método gravar(List<Mesas> m), o qual é responsável por passar o ArrayList de controle das mesas para a classe MesasDAO, chamando um método de MesasDAO passando os parâmetros m, uma instância de PedidoDAO e uma instância de ItemDoPedidoDAO. A classe MesasDAO grava as mesas e chama a classe PedidoDAO, através de um método de uma instância de PedidoDAO, passando por parâmetro uma instância de ItemDoPedidoDAO. A classe PedidoDAO é responsável por gravar os pedidos, por fim, a classe PedidoDAO chama a classe ItemDoPedidoDAO que escreve os itens do pedido no "funcionamento.txt". </p1> 

<p1> O protocolo utilizado para a gravação de itens no arquivo "item.txt" foi: </br>
Nome do Item // Tipo do Item // Valor do Item //. </br>
O protocolo utilizado para a gravação de Mesas, Pedidos e Itens do Pedido no arquivo "funcionamento.txt" foram: </br>
Nome da Mesa // Número da Mesa // Número de Pedidos da Mesa // </br>
Nome do Pedido // Número do Pedido // Status do Pedido (aberto ou fechado) // Horário de Abertura // Horário de Fechamento // Valor do Pedido // Número de Itens do Pedido // </br>
Nome do Item // Tipo do Item // Valor do Item // Quantidade de Itens // </br> </p1>

<p1> Segue no link uma foto para demonstrar um diagrama de classes a fim de melhorar a visualização da disposição das classes </p1>

<p1> Imagem: https://drive.google.com/open?id=1fjNcLqjFQU9j6IEJQjDJekS_dZ27H6oD </br> 
Obs: Seta tracejada significa nesse caso visibilidade.
</p1>

<h2> - Melhorias Futuras </h2>

<p1> Melhorias futuras podem ser realizadas na utilização de XML, abordando de forma mais precisa e melhor os arquivos. No que diz respeito a gravação dos dados, uma melhor disposição dos arquivos de acordo com a escolha do usuário poderia ser uma boa melhoria. Por exemplo, o usuário escolher em qual pasta estão os dois arquivos. </p1>

<p1> Proteção de leitura, gravação e modificação dos arquivos também seria uma melhoria futura interessante e que traria mais segurança a execução do programa, pois o mesmo saberia que os dados estavam gravados de forma correta. </p1>

<p1> Uma outra boa melhoria futura seria uma leitura mais rápida do arquivo, devido ao fato que a sua leitura é sequencial e isso poderá fazer com que a leitura de todos os dados demorem, quanto maior ficar o arquivo. Uma solução de melhoria de leitura eficiente seria bom para que os dados fossem lidos de forma mais rápida. A utilização de Banco de Dados também é uma melhoria futura necessária. </p1>

<p1> Por fim, as questões de melhorias gráficas foram descritas na primeira parte do trabalho e podem ser encontradas abaixo. </p1>

<h1> Parte 1 - Trabalho da Pizzaria </h1>

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

<p1> O modelo de dados pode ser visualizado em: https://imgur.com/a/RGkc9 ou https://drive.google.com/open?id=0B7FVQjttNXUFTi1qcE4xdVQ0U2c </br>
No geral, o diagrama só mostra o relacionamento entre as classes mais importantes. </br>
Não foi possível colocar a imagem aqui, por isso, o link. </p1>

<h2> - Campos necessários para a construção das telas </h2>

<p1> Primeiramente, acho importante dizer que ao todo foram utilizadas 7 janelas no projeto. A primeira janela é a "Janela Principal", nela é utilizada uma divisão de tela, onde dois JButtons são utilizados. Um para gerenciar os itens e outro o funcionamento. </br>

Caso o primeiro botão seja apertado, a "Janela Controle Item" é instanciada e ela possui um Combo Box, um JPanel, JList, JLabels, Box Horizontais e Box Verticais e, por fim, JRadioButton também são utilizados. No geral, os componentes gráficos são utilizados para preencher campos de novos itens e para alterar itens, e o JList é utilizado para listar os itens já existentes. Os botões, no geral, são utilizados para confirmar, alterar e excluir. </br>

Caso o segundo botão seja apertado, a "Janela Controle Funcionamento" é instanciada e ela é mais complexa, pois possui ligada a ela 4 outras janelas. Ela é composta por duas JLists, 8 JButtons. Essa janela servirá para fazer o controle do funcionamento da pizzaria. O primeiro botão serve para criar uma nova mesa, sendo que há um contador de mesas e o nome é colocado automaticamente. O segundo botão serve para excluir uma mesa selecionada. </br>

O terceiro botão chamado de "Realizar Pedido" oferece uma nova janela, a "Janela Pedido", onde existe o Combo Box, vertical box, JPanel, JTextFieldSomenteNumeros (Retirado de: http://www.devmedia.com.br/como-alterar-o-componente-jtextfield-para-aceitar-apenas-numeros/26152) e alguns JLabels, são utilizados em duas ocasiões, para realizar um pedido novo ou para acrescentar algo a um pedido, possuindo dois construtores. O cliente digita no campo a quantidade de determinado item desejado e muda o tipo do item desejado no combo box. Realizar Pedido também possui um botão, o confirmar, o qual confirma o pedido do cliente e informa o valor parcial. Um botão relacionado é o Excluir Pedido, onde um pedido pode ser excluído selecionando uma mesa e um pedido da mesa. </br>

"Ver Cardapio" é mais um botão e instancia mais uma janela, a "Janela Cardápio", onde Combo Box é utilizado, JLabels e JPanel, além de vertical box. "Ver Pedidos" é muito semelhante a outro botão, o "Fechar Conta", onde, cada um, respectivamente, instanciam "Janela Lista Pedidos" e "Janela Conta". Ambas utilizam JLabels, JPanels, além de vertical box para demonstrarem os pedidos e as compras feitas pelos clientes. Por fim, o último botão é o Total Faturado, o qual utiliza JOptionPane para exibir o valor todo ganho no dia de funcionamento. </br>

Vale citar que diversos JOptionPane são utilizados, principalmente para demonstrar erros ou alguma coisa feita de forma errada dentro do sistema. Em alguns casos, o usuário deverá responder "Sim" ou "Não", em outros, não há necessidade, ele somente deverá conferir o que foi feito. </p1>

<h2> - Pontos importantes da interface </h2>

<p1> A interface gráfica, inicialmente, foi dividida em duas partes, a parte de administração dos itens e administração do funcionamento. Quando iniciado, o software possui dois botões, o primeiro botão se refere a administração dos itens e o segundo a administração do funcionamento. </br>

Na parte de administração dos itens, o usuário terá uma nova janela e um combo box e ele poderá adicionar um novo item, onde informará o nome e uma pequena descrição do item, após irá escolher a que tipo de item pertecente, e por fim, a pessoa irá informar o valor. Na parte de alterar um item, o usuário irá ver uma lista e deverá escolher um item para alterar e selecionar o botão alterar. Uma nova janela será aberta e ele modificará o item como se estivesse criando um novo. Por fim, o usuário poderá excluir um item específico, cabe a ele selecionar o item e apertar excluir. </br>

Na parte de administração do funcionamento, uma nova janela surgirá e um usuário pode adicionar uma mesa, a qual terá seu número atribuído automaticamente, poderá excluir uma mesa só a selecionando. O usuário também poderá realizar um pedido, onde uma nova janela irá surgir e o usuário deverá selecionar o tipo de item que ele quer, e digitar o número que ele deseja de um determinado item e por fim apertar confirma. Um usuário também pode excluir um pedido que ele criou. Ele também poderá ver o cardápio que abrirá uma nova janela com um combo box. Ver pedido, mais uma funcionalidade, abrirá uma nova janela, onde ele poderá ver a hora que o pedido foi aberto, a hora que foi fechado, se já estiver fechado, os itens de um pedido e a quantidade. O total faturado exibirá o valor total recebido em um JOptionPane e o Fechar Conta, funciona como um fechar pedido, onde o usuário poderá encerrar um pedido. Ele seleciona a mesa e o pedido desejado, e aperta fechar conta e uma nova janela é aberta. Ele irá ver as informações como em Ver Pedido, de forma bastante semelhante. </p1>

<h2> - Maiores dificuldades de implementação </h2> 

<p1> Na minha opinião, grandes dificuldades foram encontradas no que diz respeito a se trabalhar com várias janelas e a forma como elas se comunicam. Por exemplo, quando uma janela é fechada, o que a outra realiza. Outro fator que me chamou atenção foi a dificuldade em somente possuir uma janela aberta, e não várias simultaneamente. </br>

Uma outra grande dificuldade foi no quesito de como apresentar uma bela interface com boas funcionalidades. Isso aconteceu pois a formatação da tela não foi uma tarefa fácil, algumas dificuldades com o tamanho da tela, o JScrollPane foram encontradas, pois nem sempre o que era esperado era realizado seja pelo JScrollPane ou mesmo o tamanho da tela. Em alguns casos, o JScrollPane ficava limitado pelo vertical box e não era simples modificá-lo. </br>

Creio que no geral a maior dificuldade foi na formatação da tela para o cliente e o usuário possuírem uma boa visualização do produto e tratar possíveis erros que poderiam acontecer, erros muitas vezes causados pelo usuário. Esses erros foram difíceis de tratar na hora de um usuário criar um novo item e alterá-lo, onde inserções devem ser feitas e um usuário pode cadastrar um item de forma errada. </p1>

<h2> - Melhorias futuras </h2> 

<p1> Melhorias futuras podem ocorrer com a utilização de um banco de dados, onde controlar a quantidade de itens disponíveis
pode se apresentar como uma boa solução. Além disso, a utilização do Banco de Dados pode oferecer ao sistema um maior controle e administração dos dados através de novas funcionalidades que possam surgir para melhorar o funcionamento do software. </br>

Outra melhoria futura que pode vir a ser interessante seria a possibilidade de alterar um pedido o qual já foi realizado, dessa maneira, não seria necessária a exclusão do mesmo para depois realizá-lo novamente. Poderia haver um controle maior também sobre o número dos pedidos, podendo ser reiniciada a contagem de acordo com a vontade do cliente. Outra mudança interessante se trata da possibilidade de poder realizar a descrição dos itens, sobre a forma de preparação para pessoas que possam vir a ter problemas com ingredientes. No "Total faturado", uma boa melhoria futura seria mostrar a quantidade de itens que foram consumidos, para saber quais itens atraem mais os clientes e são vendidos. </br>

Na questão de tratamento de erros, poderá ser pensado em como tratar erros que podem surgir na hora de adicionar um item ou alterá-lo. Mais uma melhora seria no quesito de tipo do item, onde uma boa melhoria seria o usuário poder criar novos tipos além dos existentes: pizzas salgadas, pizzas doces, refrigerantes e sobremesas. </br>

Na questão de interface gráfica, uma maior adaptabilidade da tela a diferentes monitores poderia ser uma boa melhoria futura. O tratamento de erros e a abertura de diversas janelas simultâneas também podem ser melhores trabalhadas no quesito de serem mais fáceis quando um botão é apertado, por exemplo, quando confirmado o pedido, a janela fechar no exato momento. Além do que já foi citado, uma melhoria do aspecto de beleza poderia ser realizado futuramente também. </p1>
