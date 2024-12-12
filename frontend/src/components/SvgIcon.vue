<template>
    <div v-html="icon"></div>
</template>
<script>
    export default {
        name: 'SvgIcon',
        props: {
            icon: {
                type: String,
                required: true
            }
        }
    };
</script>
<style scoped>
    div {
        display: inline-block;
        vertical-align: middle;
    }
</style>