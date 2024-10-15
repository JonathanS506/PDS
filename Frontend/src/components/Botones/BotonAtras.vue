<template>
  <v-btn color="grey" @click="goBack">
    <v-icon left>mdi-arrow-left</v-icon>
    Atrás
  </v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goBack = () => {
  router.back()
}
</script>

<style scoped>
.v-btn {
  margin: 10px;
}
</style>
