<template>
  <v-btn color="primary" @click="goToRetiroCols"> Retiro ₡</v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToRetiroCols = () => {
  router.push('/realizar-retiro-colones')
}
</script>

<style scoped></style>
