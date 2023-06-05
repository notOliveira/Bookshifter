<template>
  <link
    rel="stylesheet"
    href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
    integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
    crossorigin="anonymous"
  />

  <!-- Email-btn -->
  <div class="email-suport">
    <router-link to='/' class="suport-icon" target='_blank'>
      <i class="far fa-envelope"></i>
    </router-link>
  </div>

  <!-- Botão whatsapp -->
  <div class="buttonzap">
    <a href='https://api.whatsapp.com/send?phone=5511943560779&' class="icon" target='_blank'>
      <i class="fab fa-whatsapp"></i>
    </a>
  </div>

  <div class="container">
    <footer>
    <div class="row foot">
      <div class="col">
        <h1>Bookshifter</h1>
          <router-link to="/about" class="routers"><p>Conheça mais da nossa proposta!</p></router-link>
        </div>
        <div class="col">
          <h2>Links</h2>
          <ul>
            <li><router-link to="/books" class="routers">Ver livros</router-link></li>
            <li><router-link to="/" class="routers">Suporte</router-link></li>
            <li><router-link to="/" class="routers">Política de privacidade</router-link></li>
          </ul>
        </div>
        <div class="col">
          <h2>Copyright <sup>© </sup><router-link to="/" class="routers">Bookshifter</router-link></h2>
        </div>
      </div>
    </footer>
    <footer id="footer-social">
      <ul class="row foot-icons" style="list-style-type: none;">
        <li>
          <a href="https://fatecdiadema.com.br" target="_blank">
            <i class="fa fa-university fa-3x"></i>
          </a>
        </li>
        <li>
          <a href="https://github.com/Bookshifter" target="_blank">
            <i class="fab fa-github fa-3x"></i>
          </a>
        </li>
      </ul>
   </footer>

  </div>
    
</template>

<style scoped>

.foot {
  margin: 0 10% 0 10%;
}
.container {
  margin: 0;
}

footer {
  width: 100vw;
  height: auto;
  background-color: var(--blue);
  color: white;
  border-top: 2px solid white;
}

.routers {
  text-decoration: none;
  color: white;
}

.routers:hover {
  text-decoration: none;
  color: rgb(215, 215, 215);
}
</style>

<script>
export default {
    name: "Footer"
}

</script>