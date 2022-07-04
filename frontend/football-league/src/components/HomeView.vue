<template>
  <div>
 
    <h1>FOOTBALL LEAGUE</h1>

      <nav>
        <RouterLink to="/teams">Teams</RouterLink>
        <RouterLink to="/standing">Standing</RouterLink>
        <RouterLink to="/fixture">Fixtures</RouterLink>
      </nav>
  </div>
</template>
<script>
import { RouterLink, RouterView } from 'vue-router'

export default {
  
}
</script>
<style>

</style>