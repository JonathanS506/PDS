<template>
  <v-btn color="primary" @click="goToRetiroDols"> Retiro $</v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToRetiroDols = () => {
  router.push('/realizar-retiro-dolares')
}
</script>

<style scoped></style>
