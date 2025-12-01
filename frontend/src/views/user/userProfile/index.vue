<script setup>
import { computed } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()

const username = computed(() => route.params.username)
</script>


<template>
  <div class="user-profile">
    <h2>User Profile</h2>
    <p>Username: {{ username }}</p>
    <!-- Additional user profile details can be added here -->
  </div>
</template>



<style scoped>  

</style>