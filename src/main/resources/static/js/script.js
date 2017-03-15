function redirecionar(endereco) {
  if (document.URL.includes("user")) {
    window.location.href = "/user/" + endereco;
  } else {
    window.location.href = "/company/" + endereco;
  }
}
