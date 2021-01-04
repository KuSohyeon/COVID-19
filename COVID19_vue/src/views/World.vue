<template>
     <v-container>
           
           <global-today></global-today>
           <global-list></global-list>
    </v-container>
</template>
<script>
import GlobalToday from '@/components/world/GlobalToday.vue';
import GlobalList from '@/components/world/GlobalList.vue';

export default {
    components: {
        GlobalList,
        GlobalToday,
    }
}
</script>
<style scoped>

</style>