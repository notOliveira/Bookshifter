<template>
    <nav>
        <ul>
          <li class="primary-nav"><router-link to="/">Bookshifter</router-link></li>
          <li class="secondary-nav"><router-link to="/about">Sobre o Bookshifter</router-link></li>
          <li class="secondary-nav"><router-link to="/books">Meus livros</router-link></li>
        </ul>
      </nav>
</template>

<script>
export default {
    name: "Navbar"
}

</script>

<style scoped>

@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500&display=swap');

nav>ul>li {
  display: inline-block;
}

nav {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  z-index: 999;
  background-color: #1B3764;
  overflow: auto;
  padding: 10px 30px 20px 10px;
  font-family: "Montserrat";
}

.primary-nav {
  float: left;
  font-size: 20px;
  top: 100%;
}

.primary-nav>a {
  letter-spacing: 5px;
}

.secondary-nav>a {
  letter-spacing: 1px;
  color: var(--lyrics);
  font-family: "Montserrat";
  font-size: 16px;
  letter-spacing: 1px;
  padding-right: 20px;
}

.secondary-nav {
  margin-right: 10px;
  margin-left: 10px;
  font-size: 20px;
  float: right;
}

nav>ul>li>a {
  color: rgb(255, 255, 255);
  font-family: "Montserrat";
  text-decoration: none;
}

nav>ul>li>a:hover {
  color: rgb(215, 215, 215);
}

</style>