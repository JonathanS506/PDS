<template>
  <v-btn color="primary" @click="goToClienteFisico"> Cliente Físico</v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToClienteFisico = () => {
  router.push('/crear-cliente-fisico')
}
</script>

<style scoped></style>
