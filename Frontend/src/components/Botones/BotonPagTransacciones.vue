<template>
  <v-btn color="primary" @click="goToMenuTransacciones"> Transacciones </v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToMenuTransacciones = () => {
  router.push('/menu-transacciones')
}
</script>

<style scoped></style>
