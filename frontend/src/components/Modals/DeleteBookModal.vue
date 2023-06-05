<template>
    <div class="modal-backdrop">
        <div class="modal">
          <header class="modal-header">
            <slot name="header">Tem certeza de que deseja excluir este livro?</slot>
            <button type="button" class="btn-close" @click="close">X</button>
          </header>
    
          <section class="modal-body">
            <slot name="body">
              <form id="bookForm" role="form" method="DELETE" @submit.prevent="deleteBook(id)">
                <footer class="modal-footer">
                  <input type="submit" class="button_form delete_button" value="Excluir"/>
                  <input type="submit" class="button_form cancel_button" @click.prevent="close" value="Cancelar"/>
                </footer>
              </form>
            </slot>
           </section>
        </div>
      </div>
  
</template>

<style scoped>

.button_form {
  justify-content: center;
  background-color: #ff0000;
  border-radius: 20px;
  width: 100%;
  cursor: pointer;
}

.delete_button {
    background-color: #ff3c3c;
    color: white;
    font-weight: bold;
    border-radius: 20px;
    border: 1px solid #000;
  }

.delete_button:hover {
  background-image: linear-gradient(30deg, #ff3c3c, #ef0b0b);
}

.cancel_button {
    background-color: #e7dfdf;
    color: #000;
    border: 1px solid black;
    margin-top: 10px;
    font-weight: bold;
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
    box-shadow: 2px 2px 20px 1px;
    overflow-x: auto;
    display: flex;
    flex-direction: column;
    width: 40vw;
    font-size: 10px;
    display: flex;
    border-radius: 10px;
  }

  .modal input {
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 98%;
    height: 40px;
    border-radius: 10px;
    padding-left: 20px;
    font-size: 12pt;
  }

  .modal-header,
  .modal-footer {
    border-radius: 10px;
    font-size: 30pt;
    padding: 15px;
    display: flex;
  }

  .modal-header {
    position: relative;
    color: #000;
    font-size: 20pt;
    justify-content: center;
    background-color: #fff;
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
    color: #ffffff;
    background: transparent;
  }

</style>

<script>
export default {
  name: "DeleteBookModal",
  props: {
    id: {
      type: Number,
      required: true
    }
  },

  data() {
    return {
        id:this.id
        };
    }, 
  methods: {      
    async deleteBook(idBook) {
      const API_URL = "http://localhost:8080/";

        const req = await fetch(API_URL + `book/delete/${idBook}`, {
          method: 'DELETE',
          headers: { 
            "Content-Type" : "application/json" 
          },
        }
      );

      const res = await req;
      console.log(res);

      if (res.status != 200) {
        alert("Erro: o livro não pode ser deletado.")
      } else {
        alert("Livro deletado!");
      }
      window.location.reload()
      
      },

      close() {
        this.$emit('close');
      }

      }
    }
</script>