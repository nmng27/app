package nr.com.fiap.hermes.Comps.ListaEmails

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nr.com.fiap.hermes.Comps.Emails.Emails
import nr.com.fiap.hermes.Models.Email
import nr.com.fiap.hermes.ui.theme.HermesTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ListaEmails() {

    fun get_all_emails():List<Email>{
        return listOf(
            Email(
                id = 1,
                destinatario = "destinatario@destinatario.com",
                remetente = "remetente@remetente.com",
                assunto = "assunto",
                corpo = "corpo",
                usuarioId = 3,
                categoria = "Inbox"
            ),
            Email(
                id = 2,
                destinatario = "destinatario@destinatario.com",
                remetente = "remetente@remetente.com",
                assunto = "assunto",
                corpo = "corpo",
                usuarioId = 3,
                categoria = "Inbox"
            ),
            Email(
                id = 3,
                destinatario = "destinatario@destinatario.com",
                remetente = "remetente@remetente.com",
                assunto = "assunto",
                corpo = "corpo",
                usuarioId = 3,
                categoria = "Inbox"
            ),
            Email(
                id = 4,
                destinatario = "destinatario@destinatario.com",
                remetente = "remetente@remetente.com",
                assunto = "assunto",
                corpo = "corpo",
                usuarioId = 3,
                categoria = "Inbox"
            ),
            Email(
                id = 5,
                destinatario = "destinatario@destinatario.com",
                remetente = "remetente@remetente.com",
                assunto = "assunto",
                corpo = "corpo",
                usuarioId = 3,
                categoria = "Inbox"
            )
        )
    }
    LazyColumn {
        items(get_all_emails()){
            Emails(remetente = it.remetente,
                assunto = it.assunto)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
private fun ListaEmailsPreview() {
    HermesTheme {
        ListaEmails()
    }
}