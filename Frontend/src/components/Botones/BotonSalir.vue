<template>
  <v-btn color="red" @click="goToPagPrincipal"> Salir</v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToPagPrincipal = () => {
  router.push('/')
}
</script>

<style scoped></style>
