<template>
    <div>
        <button @click="logout" class="logout-btn">Logout</button>
    </div>
</template>

<script>
    export default {
        name: 'LogoutBtn',
        methods: {
            logout() {
                localStorage.removeItem('auth');
                this.$router.push('/');
            }
        }
    }
</script>