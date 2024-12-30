<template>
    <AutomaticDep></AutomaticDep>
</template>

<script>
import AutomaticDep from '@/components/AutomaticDep.vue';
export default {
    name: 'AutomaticDepositPage',
    props: {
        isDarkMode: {
            type: Boolean,
            default: false
        }
    },
    components: {
        AutomaticDep
    }
}
</script>