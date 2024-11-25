<template>
    <div :class="['user-view',{'dark-mode':isDarkMode}]">
        <h1>ITS ALIVE</h1>
    </div>
</template>

<script>
    export default {
        name: 'UserView',
        props:{
            isDarkMode:{
                type:Boolean,
                required:true
            }
        },
    }
</script>
<style scoped>
  .user-view {
    display: flex;
    flex-direction: column;
    transition: background-color 0.3s;
    height: 100vh;
}
.user-view.dark-mode {
  background-color: #192229;
  color: #a0a7ac;
}

.user-view:not(.dark-mode) {
  background-color: white;
  color: black;
}
</style>