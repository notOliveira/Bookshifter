<template>
  <section class="items">
    <h1 class="myBooks">Meus livros</h1>
    <div class="noBooks" v-if="books == 0">
      <h1>Você não tem livros...</h1>
      <img class="header-img" src="../../public/images/sad-face.png"/>
    </div>
    <div v-else class="row">
      <div class="col2">
        
        <!-- CARD -->
        <div  class="items2" v-for="book in books" :key="book.id">
          <div class="card">
            <img v-bind:src="book.image">

            <!-- Título -->
            <h3 v-if="book.name == ''">Livro sem título</h3>
            <h3 v-else>{{book.name}}</h3>

            <!-- Autor-->
            <p v-if="book.author == ''">Sem autor</p>
            <p v-else>{{book.author}}</p>

            <!-- Quantidade -->
            <p v-if="book.quantity > 1">{{book.quantity}} disponíveis</p>
            <p v-else-if="book.quantity == 1">{{book.quantity}} disponível</p>
            <p v-else>Sem livros disponíveis</p>

            <!-- Preço -->
            <p class="price" v-if="book.price > 0">R$ {{ book.price }}</p>
            <p class="price" v-else>Para doação</p>
            <br>
            <button type="button" class="button_form edit_button" @click.prevent="openEditModal(book)" :selectedBook="book">Editar</button>
            <button type="button" class="button_form delete_button" @click.prevent="openDeleteModal(book.id)" :id="book.id">Apagar</button>
            <!-- <button type="button" class="button_form delete_button" @click.prevent="deleteBook(book.id, book.name)">Deletar</button> -->
          </div>
        </div>

      </div>
    </div>
    <center><button type="button" class="addBook" @click.prevent="CB_ModalVisible = true"><span>+</span> Adicionar livro</button></center>
    <CreateBookModal 
    v-if="CB_ModalVisible"
    @close="closeCB_Modal"
    />

    <EditBookModal 
    v-if="EB_ModalVisible"
    :selectedBook="selectedBook"
    @close="closeEB_Modal"
    />

    <DeleteBookModal 
    v-if="DB_ModalVisible"
    :id="id"
    @close="closeDB_Modal"
    />
    
  </section>
  
</template>

<script>

import DeleteBookModal from '@/components/Modals/DeleteBookModal.vue';
import CreateBookModal from '../components/Modals/CreateBookModal.vue';
import EditBookModal from '@/components/Modals/EditBookModal.vue';

export default {
  components: {
  CreateBookModal,
  EditBookModal,
  DeleteBookModal
},
  data() {
    return {
      selectedBook: null,
      CB_ModalVisible: false,
      EB_ModalVisible: false,
      DB_ModalVisible: false,
      books: null
    }
  },
  
  methods:{

    // GET API
    async getBooks() {
      const API_URL = "http://localhost:8080/";
      const req = await fetch(API_URL + 'book');
      const data = await req.json();

      console.log(data);

      if (data == []) {
        this.books = 0;
      } else {
        this.books=data;
      }
    },

    // DELETE API CONFIRM
    // async deleteBook(id, name) {

    //   if(!confirm(`Deseja mesmo deletar o livro ${name}?`)){
    //   return;
    // }
    //   const API_URL = "http://localhost:8080/";

    //   const req = await fetch(API_URL + `book/delete/${id}`, {
    //     method: 'DELETE',
    //     headers: { 
    //       "Content-Type" : "application/json" 
    //     },
    //   }
    // );

    // const res = await req;
    // console.log(res);

    // alert("Livro deletado!");
    
    // window.location.reload()
  
    // },

    // CREATE Modal

    openCreateModal() {
      this.CB_ModalVisible = true;
    },

    closeCB_Modal() {
      this.CB_ModalVisible = false;
      window.location.reload()
    },

    // EDIT Modal

    openEditModal(book) {
      this.selectedBook = book;
      this.EB_ModalVisible = true;
    },

    closeEB_Modal() {
      this.EB_ModalVisible = false;
      window.location.reload()
    },

    // DELETE Modal

    openDeleteModal(idBook) {
      this.id = idBook;
      this.DB_ModalVisible = true;
    },

    closeDB_Modal() {
      this.DB_ModalVisible = false;
      window.location.reload()
    },
    
  },
  mounted() {
    this.getBooks();
    
  }
}
</script>

<style scoped>

@import url('https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap');

.button_form {
  margin-right: 20px;
  text-align: center;
  border-radius: 20px;
  color: white;
  width: 80px;
  max-width: 80px;
  height: 50px;
  cursor: pointer;
}

.delete_button {
  background-color: #da1a29;
  border: 1px solid #da1a29;
  font-weight: bold;
}

.delete_button:hover {
background-image: linear-gradient(30deg, #da1a29, #7e0a14);
}

.edit_button {
  background-color: #132b51;
  border: 1px solid #132b51;
  font-weight: bold;
}

.edit_button:hover {
  background-image: linear-gradient(30deg, #132b51, #092e69);
}

.myBooks {
width: 100%;
color: rgb(255, 255, 255);
background-color: var(--blue);
margin-top: 0;
}

.noBooks {
display:flex;
align-items: center;
flex-direction: column;
}

.addBook {
background-color: #1B3764;
font-weight: bold;
margin-bottom: 20px;
color: white;
cursor: pointer;
width: 200px;
height: 50px;
font-size: 17px;
border-radius: 20px;
border: 1px solid #1B3764;
text-decoration: none;
font-family: 'Montserrat';
}

.addBook:hover {
    background-image: linear-gradient(30deg, #132b51, #1B3764);
}

section {
margin:0;
padding: 0;
font-family: "Montserrat";
background-color: whitesmoke;
border-radius: 10px;
overflow-x: hidden;
scroll-behavior: none;
scroll-snap-type: none;
}

.items {
margin-top: 0;
background-color: rgb(222, 222, 222)}
-webkit-scrollbar-track { 
  background-color: #ffffff;
} ::-webkit-scrollbar { 
  width: 6px; background: #6184bb; 
} 

::-webkit-scrollbar-thumb { 
  background: #1B3764; 
}


.items {
margin: 7% 10% 5% 10%;
}

.row {
display: inline-flexbox;
flex-direction: row;
}

.col2 {
padding-left: 100px;
position: relative;
}

section h1 {
font-size: 50px;
text-align: center;
}

.header-img {
width: 20%;
object-fit: cover;
}

img {
  border-radius: 10px;
}

.card {
background-color: #ffff;
display:block;
border-radius: 5%;
text-align: center;
max-width: 300px;
width: 300px;
height: 600px;
max-height: 600px;
margin-right: 20px;
padding: 10px;
}

.card>h3 {
color: rgb(0, 0, 0);
margin: 0;
padding-top: 10px;
padding-bottom: 1px ;
}

.card>p {
margin: 0;
padding: 9px;
font-size: 13pt;
color: rgb(0, 0, 0);
}

.card>.price {
color: rgb(70, 70, 70);
}

.items2 {
display: inline-block;
flex-direction: row;
flex-wrap: wrap;
justify-content: center;
margin-bottom: 30px;
}


.card>img {
width: 250px;
max-width: 250px;
height: 350px;
max-height: 350px;
overflow: hidden;

}

input {
margin-bottom: 10px;
}

@media (max-width: 1400px) {
.card {
  max-width: 250px;
}
}

@media (max-width: 768px) {
.row {
  flex-direction: column;
}

.items {
  margin: 0;
  padding: 0;
}
.col2 {
  padding: 0;
}
}
</style>