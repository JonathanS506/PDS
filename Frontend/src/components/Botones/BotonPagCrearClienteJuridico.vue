<template>
  <v-btn color="primary" @click="goToClienteJuridico"> Cliente Jurídico</v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToClienteJuridico = () => {
  router.push('/crear-cliente-juridico')
}
</script>

<style scoped></style>
