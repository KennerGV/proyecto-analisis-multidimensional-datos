<template>
  <div class="home">
   <!--  <img alt="Vue logo" src="../assets/logo.png"> -->
    <Vivero msg="Vivero"/>
  </div>
</template>

<script>
// @ is an alias to /src
import Vivero from '@/components/Vivero.vue'

export default {
  name: 'home',
  components: {
    Vivero
  }
}
</script>
