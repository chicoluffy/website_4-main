<template>
    <div>
      <button :class="['btn',isDarkMode ? 'btn-light' : 'btn-dark','btn-rounded-fill']" @click="toggleDarkMode">
        <i :class="isDarkMode ? 'bi bi-sun-fill' : 'bi bi-moon-fill'"></i>
      </button>
    </div>
</template>
<script>
import EventBus from '@/eventBus/eventBus';
export default{
    name: 'SwitchBtn',
    props: {
        isDarkMode:{
            type: Boolean,
            required: true
        }
    },
    methods:{
        toggleDarkMode(){
          const newMode = !this.isDarkMode;
          document.querySelector("body").setAttribute("data-bs-theme", newMode ? "dark" : "light");
          localStorage.setItem('dark-mode', newMode);
          EventBus.emit('toggle-dark-mode', newMode);
          this.$emit('update:isDarkMode', newMode);
            //localStorage.setItem('dark-mode', newMode);
            //EventBus.emit('toggle-dark-mode', newMode);
        }
    }
}
</script>
