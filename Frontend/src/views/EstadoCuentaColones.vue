<template>
  <v-container class="fill-height" fluid>
    <v-row align="center" justify="center">
      <v-col cols="12">
        <EstadoCuentaColonesFormulario />
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import EstadoCuentaColonesFormulario from '@/components/EstadoCuentaColonesFormulario.vue'
</script>

<style scoped>
.fill-height {
  min-height: 100vh;
}
</style>
