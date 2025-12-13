<template>
  <div class="not-found">
    <h1>404 - Page Not Found</h1>
    <p>The page you are looking for does not exist.</p>
    <router-link to="/index">Go back home</router-link>
  </div>
</template>

<script setup>
</script>

<style scoped>
.not-found {
  text-align: center;
  margin-top: 100px;
}
.not-found h1 {
  font-size: 3rem;
  color: #ff4d4f;
}
.not-found p {
  font-size: 1.2rem;
  margin: 1em 0;
}
</style>
