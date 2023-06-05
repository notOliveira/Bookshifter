<template>
    <div class="modal-backdrop">
        <div class="modal">
          <header class="modal-header">
            <slot name="header">Adicionar livro</slot>
            <button type="button" class="btn-close" @click="close">X</button>
          </header>
    
          <section class="modal-body">
            <slot name="body">
              <form id="bookForm" role="form" method="POST" @submit.prevent="postBook">
                <div class="form-group">
                  <br>
                  <label class="labels-form">Nome do livro</label>
                  <br>
                  <input type="text" class="form-control" v-model="name" placeholder="Ex: A Moreninha">
                  <br>
                  <br>

                  <label class="labels">Imagem</label>
                  <br>
                  <input type="text" class="form-control" v-model="image" placeholder="Link da imagem">
                  <br>
                  <br>

                  <label class="labels">Autor</label>
                  <br>
                  <input type="text" class="form-control" v-model="author" placeholder="Ex: Machado de Assis">
                  <br>
                  <br>

                  <label class="labels">Editora</label>
                  <br>
                  <input type="text"  class="form-control" v-model="publisher" placeholder="Ex: Companhia das Letras">
                  <br>
                  <br>

                  <label class="labels">Categoria</label>
                  <br>
                  <input type="text" class="form-control" v-model="category" placeholder="Ex: Romance">
                  <br>
                  <br>

                  <label class="labels">Descrição do livro</label>
                  <br>
                  <input type="text" class="form-control" v-model="description" placeholder="Sinopse do livro">
                  <br>
                  <br>

                  <label class="labels">Quantidade de livros disponíveis</label>  
                  <br>
                  <input type="number" class="form-control" v-model="quantity" placeholder="Deve possuir valor positivo">
                  <b>OBS: o valor deve ser maior ou igual a 0</b>
                  <br>
                  <br>

                  <label class="labels">Preço do livro</label>
                  <br>
                  <input type="double" class="form-control" v-model.number="price">
                  <b>OBS: o valor deve ser maior ou igual a 0.</b>
                  <br>
                  <b>Para doar, o valor deve ser 0.</b>
                  <br>
                  <br>
                </div>
                <footer class="modal-footer">
                  <input type="submit" class="submit_button" value="Criar livro"/>
                </footer>
              </form>
            </slot>
           </section>
        </div>
      </div>
  
</template>

<style scoped>

.submit_button {
  justify-content: center;
  background-color: #1B3764;
  border-radius: 20px;
  color: white;
  width: 100%;
  height: 50px;
  cursor: pointer;
}

.submit_button:hover {
  background-image: linear-gradient(30deg, #0e2852,#1B3764);
}

b {
  font-size: 15px;
  color: red;
}
.form-group {
  justify-content: center;
}
.modal-backdrop {
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    background-color: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
    
  }

  .modal {
    background: #FFFFFF;
    border-radius: 25px;
    border: 1px solid #0e2852;
    box-shadow: 2px 2px 20px 1px;
    overflow-x: auto;
    display: flex;
    flex-direction: column;
    width: 60vw;
    height: 70vh;
    display: flex;
  }

  .modal input {
    display: flex;
    align-items: center;
    border: 1px solid black;
    width: 97%;
    height: 40px;
    border-radius: 10px;
    padding-left: 20px;
    font-size: 12pt;
  }

  .modal-header,
  .modal-footer {
    font-size: 30pt;
    padding: 15px;
    display: flex;
  }

  .modal-header {
    position: relative;
    border-bottom: 1px solid #eeeeee;
    color: #fff;
    font-weight: bold;
    height: 200px;
    justify-content: center;
    background-color: #1B3764;
    border-radius: 10px;
  }

  .modal-footer {
    border-top: 1px solid #eeeeee;
    flex-direction: column;
    justify-content: flex-end;
  }

  .modal-body {
    position: relative;
    padding: 20px 10px;
  }

  .btn-close {
    position: absolute;
    top: 0;
    right: 0;
    border: none;
    font-size: 20px;
    padding: 10px;
    cursor: pointer;
    font-weight: bold;
    color: #ffff;
    background: transparent;
  }

</style>

<script>
export default {
  name: "CreateBookModal",
  data() {
    return {
      name: '',
      image: '',
      author: '',
      publisher: '',
      quantity: 0,
      price: 0,
      category: '',
      description: ''
        };
    }, 
  methods: {
    async postBook() {
      const data = {
        name: this.name,
        image: this.image,
        author: this.author,
        publisher: this.publisher,
        quantity: this.quantity,
        price: this.price,
        category: this.category,
        description: this.description
          };
      
      if (data.image == '') {
        data.image = "https://plus.unsplash.com/premium_photo-1669652639337-c513cc42ead6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Ym9va3N8ZW58MHx8MHx8fDA%3D&w=1000&q=80"
      }

      console.log(data);

      const dataJson = JSON.stringify(data);

      const req = await fetch("http://localhost:8080/book/new", {
        method: "POST",
        headers: { "Content-Type" : "application/json" },
        body: dataJson
      });

      const res = await req;
      console.log(res);

      if (res.status != 201) {
        alert("Erro: o livro não pode ser criado.")
      } else {
        alert("Livro adicionado!");
      }
      window.location.reload()
      
      },

      close() {
        this.$emit('close');
      }

      }
    }
</script>