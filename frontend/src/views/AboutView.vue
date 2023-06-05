<template>
  <div class="about">
    <br><br><br>
    <title>About Us</title>
    <link rel="stylesheet" href="" />

    <link
      href="https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap" />
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
      integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
      crossorigin="anonymous"
    />

    <h1>Informações sobre a Plataforma</h1>

    <div class="map_text">
      <!-- TEXTO AO LADO DO MAPA-->
        <div class="about_map">
          <p>
            O Bookshifter é uma plataforma inovadora voltada para a venda e doação de livros, com o objetivo de combater a desigualdade educacional no Brasil. Criada com paixão e comprometimento, nossa missão é tornar os livros acessíveis a todos, independentemente de sua situação socioeconômica.
          </p>
          <p>
            Acreditamos que a educação é um direito fundamental de todos os indivíduos e que o acesso a livros de qualidade é essencial para o desenvolvimento pessoal e intelectual. Por meio do Bookshifter, proporcionamos uma plataforma onde pessoas podem comprar, vender e doar livros de forma fácil e segura.
          </p>
          <p>
            Nosso foco é incentivar a leitura e promover a igualdade de oportunidades educacionais. Ao disponibilizar livros usados a preços acessíveis e oferecer a possibilidade de doações, ajudamos a ampliar o acesso à leitura para aqueles que não teriam condições de adquirir novos livros.
          </p>
          <p>
            Além disso, o Bookshifter também trabalha em parceria com instituições e projetos sociais para levar livros a comunidades carentes e escolas públicas. Acreditamos que a educação transforma vidas e estamos empenhados em contribuir para um futuro mais justo e igualitário.
          </p>
          <p>
            Junte-se a nós nessa jornada de transformação. Acesse o Bookshifter, encontre os livros que você deseja e faça parte da nossa missão de acabar com a desigualdade educacional no Brasil.
          </p>
        </div>
              <!-- MAPA -->
      <div class="map-responsive">
        <!-- <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3654.065263498455!2d-46.6214959237016!3d-23.673623965728037!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce44c3b4727283%3A0x2ac9c7a5fa5b07eb!2sFatec%20Diadema%20-%20Luigi%20Papaiz!5e0!3m2!1spt-BR!2sbr!4v1684101594472!5m2!1spt-BR!2sbr" width="400" height="500" style="border:0;" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe> -->
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3654.065263498455!2d-46.6214959237016!3d-23.673623965728037!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce44c3b4727283%3A0x2ac9c7a5fa5b07eb!2sFatec%20Diadema%20-%20Luigi%20Papaiz!5e0!3m2!1spt-BR!2sbr!4v1684101594472!5m2!1spt-BR!2sbr" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
      </div>
    </div>

    <section>
      <h1>Nosso time</h1>
      <div class="row">
        <figure>
          <img src="../../public/images/gustavo.png" alt="" />
          <figcaption class="team-member">
            <h3>Gustavo Oliveira</h3>
            
          </figcaption>
        </figure>
        <figure>
          <img src="../../public/images/flavio.png" alt="" />
          <figcaption class="team-member">
            <h3>Flávio Kawan</h3>
            
          </figcaption>
        </figure>
        <figure>
          <img src="../../public/images/joao.png" alt="" />
          <figcaption class="team-member">
            <h3>João Kavalciuki</h3>
            
          </figcaption>
        </figure>
        <figure>
          <img src="../../public/images/eduardo.png" alt="" />
          <figcaption class="team-member">
            <h3>Eduardo Sousa</h3>
            
          </figcaption>
        </figure>
        <figure>
          <img src="../../public/images/nardi.jpg" alt="" />
          <figcaption class="team-member">
            <h3>Douglas Nardi</h3>
            
          </figcaption>
        </figure>
        <figure>
          <img src="../../public/images/anderson.jpg" alt="" />
          <figcaption class="team-member">
            <h3>José Anderson</h3>
            
          </figcaption>
        </figure>
      </div>
    </section>
  </div>
</template>

<style scoped>

  .mapouter {
    text-align: right;
    border-radius: 14px;
  }

  .row {
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: center;
    margin: 0;
  }

  h1 {
    margin-top: 40px;
    text-align: center;
  }

  p {
    text-align: justify;
  }

  .team-member p {
    text-align: center;
    font-size: 17pt;
  }

  figure > img {
    width: 25rem;
    height: 25rem;
    object-fit: cover;
    box-shadow: 0px 0px 50px rgba(0, 0, 0, 0.6);
    border-radius: 7px;
  }
  
  .about{
    font-family: "Montserrat";
    font-size: 20pt;
  }
  .about_map{
    max-width: 70vw;
    font-size: 17pt;
    width: 100%;
    font-family: "Montserrat";


    }
  .map-responsive{
    width: 90vw;
    margin: 1.5% auto;
    background: none !important;
}

.map-responsive iframe{
    position:relative;
    width: 100%;
    height: 500px;
    border-radius: 10px;

}

.map_text {
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  gap: 1rem;
  width: 100vw;
}
  
</style>
