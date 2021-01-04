<template>
     <v-container>
           <div>
                <global-today></global-today>
                <br/>
                <global-week></global-week>
                <br/>
                <global-list></global-list>
           </div>
    </v-container>
</template>
<script>
import GlobalToday from '@/components/world/GlobalToday.vue';
import GlobalList from '@/components/world/GlobalList.vue';
import GlobalWeek from '@/components/world/GlobalWeek.vue';
export default {
    components: {
        GlobalList,
        GlobalToday,
        GlobalWeek
    }
}
</script>
<style scoped>
div{
    justify-content: center;
}
</style>