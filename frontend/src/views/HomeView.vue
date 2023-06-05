<template>
  <div class="container">
    <div class="header_home_bg">
      <div class="pxtext">
        <span class="border">Doe um livro!</span>
        <br>
        <span class="border">Leve a leitura aqueles que querem ler!</span>
        <br><br><br>
        <p><router-link to="/books">Ver mais</router-link></p>
      </div>
    </div>
    <section>
      <div class="row" style="width: 80%; margin: 0 auto;">
        <div class="col">
          <div class="overlay-image">
            <router-link to="/books">
              <img class="image" src="../../public/images/img-3.jpg" alt="Alt text" />
              <div class="normal">
                <div class="text">Promova a leitura!</div>
              </div>
              <div class="hover">
                <img class="image" src="../../public/images/img-4.jpg"/>
                <div class="text">Desapegue com amor!</div>
              </div>
            </router-link>
          </div>
        </div>
        <div class="col">
          <div class="overlay-image">
            <div class="bg_opacity">
              <img class="image" src="../../public/images/img-2.jpg"/>
            </div>
            <router-link to="/books">
              <div class="normal">
                <div class="text">Livros</div>
              </div>
              <div class="hover">
                <div class="bg_opacity">
                  <img class="image" src="../../public/images/img-1.jpg" />
                </div>
                <div class="text">Espalhe a leitura!</div>
              </div>
            </router-link>
          </div>
        </div>
      </div>
    </section>
    <section class="preview">
      <h2 v-bind:style="ta_center">Aqui você pode procurar também pelos seus livros favoritos!</h2>
      <div class="row" style="width: auto; margin: 0 auto;">
        <figure class="item">
          <router-link to="/books">
            <img src="../../public/images/img-5.jpg" v-bind:style="w100"/>
            <figcaption>Classificações</figcaption>
          </router-link>
        </figure>
        <figure class="item">
          <router-link to="/books">
            <img src="../../public/images/img-7.jpg" v-bind:style="w100" />
            <figcaption>Categorias</figcaption>
          </router-link>
        </figure>
        <figure class="item">
          <router-link to="/books">
            <img src="../../public/images/img-8.jpg" v-bind:style="w100" />
            <figcaption>Livros Populares</figcaption>
          </router-link>
        </figure>
      </div>
    </section>
  </div>
</template>

<script>
// @ is an alias to /src
export default {
  data() {
    return {
      w100vw: {width: "100vw", overflow: "hidden"},
      wAuto: {width: "auto"},
      w100: {width: "100%"},
      ta_center: {textAlign: "center"}
    };
  }
};
</script>

<style>
/* ... */
</style>