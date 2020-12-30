<template>
  <v-app>
      <nav-bar/>
      <v-main class="app">
        <router-view></router-view>
      </v-main>
      <footer-bar/>
  </v-app>
</template>

<script>
import NavBar from '@/components/inc/NavBar.vue';
import FooterBar from '@/components/inc/FooterBar.vue';

export default {
  name: "App",

  components: {
    NavBar,
    FooterBar
  },

  data: () => ({
    //
  })
};
</script>
<style scoped>
.app{
  background-color:#001522;
}
</style>


