
function registrati() {
    let reg_nome = document.getElementById('nome').value;
    let reg_cognome = document.getElementById('cognome').value;
    let reg_email = document.getElementById('email').value;
    let reg_user = document.getElementById('user').value;
    let reg_password = document.getElementById('password').value;
    let reg_password_control = document.getElementById('password2').value;

//    e.preventDefault();

    if ((reg_nome !== "") &
            (reg_cognome !== "") &
            (reg_email !== "") &
            (reg_user !== "") &
            (reg_password !== "")) {

        if (reg_password === reg_password_control) {

            const utente = {
                "nome": reg_nome,
                "cognome": reg_cognome,
                "email": reg_email,
                "usr": reg_user,
                "pwd": reg_password,
            };

            fetch("http://localhost:8080/mycloud-master/resources/users",
                    {
                        headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(utente),
                        method: "post"
                    })
                    .then(res => {
                        if (res.status === 200) {
                            window.alert('Registrazione avvenuta con successo');

                        }
                    })
                    .catch(res => console.error(res));

        } else {
            // messaggio che le pw non coincidono
            window.alert('Le password non coincidono, riprova!');
        }

    } else {
        // messaggio che non sono stati inseriti tutti i dati
        window.alert('Alcuni dati sono mancanti!');
    }

}