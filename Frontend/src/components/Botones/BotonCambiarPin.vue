<template>
  <v-btn color="primary" @click="goToCambiarPin"> Cambiar Pin</v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToCambiarPin = () => {
  router.push('/cambiar-pin')
}
</script>

<style scoped></style>
