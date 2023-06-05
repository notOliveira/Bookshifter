<template>
    <div class="modal-backdrop">
        <div class="modal">
          <header class="modal-header">
            <slot name="header">Editar livro</slot>
            <button type="button" class="btn-close" @click="close">X</button>
          </header>
    
          <section class="modal-body">
            <slot name="body">
              <form id="bookForm" role="form" method="PUT" @submit.prevent="editBook(selectedBook.id)">
                <div class="form-group">
                  <br>
                  <label class="labels-form">Nome do livro</label>
                  <br>
                  <input v-model="Nname" type="text" class="form-control"  placeholder="Ex: A Moreninha">
                  <br>
                  <br>

                  <label class="labels">Imagem</label>
                  <br>
                  <input v-model="Nimage" type="text" class="form-control"  placeholder="Link da imagem">
                  <br>
                  <br>

                  <label class="labels">Autor</label>
                  <br>
                  <input v-model="Nauthor" type="text" class="form-control"  placeholder="Ex: Machado de Assis">
                  <br>
                  <br>

                  <label class="labels">Editora</label>
                  <br>
                  <input v-model="Npublisher" type="text"  class="form-control"  placeholder="Ex: Companhia das Letras">
                  <br>
                  <br>

                  <label class="labels">Categoria</label>
                  <br>
                  <input v-model="Ncategory" type="text" class="form-control"  placeholder="Ex: Romance">
                  <br>
                  <br>

                  <label class="labels">Descrição do livro</label>
                  <br>
                  <input v-model="Ndescription" type="text" class="form-control"  placeholder="Sinopse do livro">
                  <br>
                  <br>

                  <label class="labels">Quantidade de livros disponíveis</label>  
                  <br>
                  <input v-model="Nquantity" type="number" class="form-control"  placeholder="Deve possuir valor positivo">
                  <b>OBS: o valor deve ser maior ou igual a 0</b>
                  <br>
                  <br>

                  <label class="labels">Preço do livro</label>
                  <br>
                  <input v-model.numver="Nprice" type="double" class="form-control" >
                  <b>OBS: o valor deve ser maior ou igual a 0.</b>
                  <br>
                  <b>Para doar, o valor deve ser 0.</b>
                  <br>
                  <br>
                </div>
                <footer class="modal-footer">
                  <input type="submit" class="submit_button" value="Editar livro"/>
                </footer>
              </form>
            </slot>
           </section>
        </div>
      </div>
  
</template>

<script>

export default {
  name: "EditBookModal",
  props: {
    selectedBook: {
      type: Object,
      required: true
    }
  },  
  data() {
    return {
      Nname:this.selectedBook.name,
      Nimage:this.selectedBook.image,
      Nauthor:this.selectedBook.author,
      Npublisher:this.selectedBook.publisher,
      Nquantity:this.selectedBook.quantity,
      Nprice:this.selectedBook.price,
      Ncategory:this.selectedBook.category,
      Ndescription:this.selectedBook.description
        };
    }, 
  methods: {
    async editBook(idBook) {
      const data = {
        name: this.Nname,
        image: this.Nimage,
        author: this.Nauthor,
        publisher: this.Npublisher,
        quantity: this.Nquantity,
        price: this.Nprice,
        category: this.Ncategory,
        description: this.Ndescription
          };
      
      if (data.image == '') {
        data.image = "https://plus.unsplash.com/premium_photo-1669652639337-c513cc42ead6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Ym9va3N8ZW58MHx8MHx8fDA%3D&w=1000&q=80"
      }

      console.log(data);

      const dataJson = JSON.stringify(data);

      const req = await fetch(`http://localhost:8080/book/update/${idBook}`, {
        method: "PUT",
        headers: { "Content-Type" : "application/json" },
        body: dataJson
      });

      const res = await req;
      console.log(res);

      if (res.status != 200) {
        alert("Erro: o livro não pode ser editado.")
      } else {
        alert("Livro editado!");
      }
      window.location.reload()
      
      },

      close() {
        this.$emit('close');
      }

      }
    }
</script>

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
  background-color: #1B3764;
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
    width: 70vw;
    padding: 10px;
    height: 70vh;
    display: flex;
  }

  .modal input {
    display: flex;
    align-items: center;
    width: 98%;
    height: 40px;
    border-radius: 10px;
    padding-left: 20px;
    font-size: 12pt;
    border: 1px solid black
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
    border-radius: 10px;
    justify-content: center;
    background-color: #1B3764;
  }

  .modal-footer {
    border-top: 1px solid #eeeeee;
    flex-direction: column;
    justify-content: flex-end;
  }

  .modal-body {
    position: relative;
    padding: 20px 10px;
    border-radius: 10px;
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
    color: #fff;
    background: transparent;
  }

  .btn-green {
    color: white;
    background: #4AAE9B;
    border: 1px solid #4AAE9B;
    border-radius: 2px;
  }

</style>
