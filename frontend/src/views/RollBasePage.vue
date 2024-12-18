<template>
    <div :class="['roll-base-page',{'dark-mode':isDarkMode}]">
        <div class="user-roll-page">
            <h1>Users Roll</h1>
            <table class="user-table">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Username</th>
                        <th>Role</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(user,index) in users" :key="user.id">
                        <td>{{ index +1 }}</td>
                        <td>{{ user.username }}</td>
                        <td>{{ user.role }}</td>
                        <td>{{ user.status }}</td>
                        <td>
                            <div class="button-group">
                                <button @click="editUser(user.id)" class="edit-button">Edit</button>
                                <button @click="deleteUser(user.id)" class="delete-button">Delete</button>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>
<script>
    export default {
        name: 'RollBasePage',
        props:{
            isDarkMode:{
                type:Boolean,
                required:true
            }
        },
        data(){
            return{
                users :[]
            }
        },
        mounted(){
            //metodo para rellenar el array de usuarios
            this.userArray();

        },
        methods:{
            //hacer un array de usuarios
            //metodo para editar usuario
            userArray(){
                this.users = [
                {id: 1, username: 'admin', role: 'admin', status: 'active'},
                {id: 2, username: 'user1', role: 'user', status: 'active'},
                {id: 3, username: 'user2', role: 'user', status: 'active'},
                {id: 4, username: 'user3', role: 'user', status: 'active'},
                {id: 5, username: 'user4', role: 'user', status: 'active'},
            ];
            },
            editUser(userId){
                console.log('Edit user with id:', userId);
            },
            deleteUser(userId){
                console.log('Delete user with id:', userId);
            }
        }
    }
</script>

<style scoped>
.roll-base-page{
    padding: 2rem;
    background-color: #f5f5f5;
    color: #333;
    transition: background-color 0.3s,color 0.3s;
    width: 100%;
    height: 100vh;   
}
.roll-base-page.dark-mode{
    background-color: #192229;
    color: #52A5E0;
}
.user-roll-page {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 75%;
  margin: 0 auto;
  padding: 2rem;

  transition: background-color 0.3s, color 0.3s;
}
.user-roll-page.dark-mode {
  background-color: #192229;
  color: #52A5E0;
}
.h1{
    text-align: center;
    margin-bottom: 1.5rem;
}
.user-table{
    width: 100%;
    border-collapse: collapse;
    margin: 0 auto;
}
.user-table th, .user-table td{
    padding: 0.75rem;
    border: 1px solid #ccc;
    text-align: left;
}
.user-table th{
    background-color: #007BFF;
    color: white;
}
.user-table td{
    background-color: white;
}
.user-table tr:nth-child(even) td{
    background-color: #f2f2f2;
}
.button-group {
  display: flex;
  gap: 0.5rem; /* Espacio entre los botones */
}
.user-table .edit-button,.user-table .delete-button{
    padding: 0.5rem 1rem;
    font-size: 0.875rem;
    border: none;
    border-radius: 0.25rem;
    cursor: pointer;
}
.user-table .edit-button{
    background-color: #28a745;
    color: white;
}
.user-table .edit-button:hover{
    background-color: #218838;
}
.user-table .delete-button{
    background-color: #dc3545;
    color: white;
}
.user-table .delete-button:hover{
    background-color: #c82333;
}
.roll-base-page.dark-mode .user-table th{
    background-color: #2a3b47;
}
.roll-base-page.dark-mode .user-table td{
    background-color: #2a3b47;
    color: #52A5E0;
}
.roll-base-page.dark-mode .user-table tr:nth-child(even) td{
    background-color: #1f2a33;
}
.roll-base-page.dark-mode .edit-button{
    background-color: #28a745;
}
.roll-base-page.dark-mode .edit-button:hover{
    background-color: #218838;
}
.roll-base-page.dark-mode .delete-button{
    background-color: #dc3545;
}
.roll-base-page.dark-mode .delete-button:hover{
    background-color: #c82333;
}
</style>