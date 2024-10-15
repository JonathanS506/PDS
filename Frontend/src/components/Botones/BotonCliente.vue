<template>
  <v-btn color="primary" @click="goToMenuClientes"> Clientes</v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToMenuClientes = () => {
  router.push('/menu-clientes')
}
</script>

<style scoped></style>
