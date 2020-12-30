<template>
  <div class="home">
    <p class="white--text">메인페이지.</p>
      <router-link to="/korea" class="text-decoration-none "><v-btn text class="primary">국내</v-btn></router-link>
      <router-link to="/world" class="text-decoration-none"><v-btn text class="primary">해외</v-btn></router-link>
  </div>
</template>

<script>
// @ is an alias to /src


export default {
  name: "Home",
  components: {
    
  }
};
</script>
<style scoped>
.home{
  width: 30%;
  height: 100%;
}
</style>
