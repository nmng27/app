package nr.com.fiap.hermes.Lists

import nr.com.fiap.hermes.Models.Email

fun gerandoListaInbox():List<Email>{
    return listOf(
        Email(1,4,"remetente@gmail.com","destinatario@gmail.com","Inbox","Assunto","corpo"),
        Email(2,4,"remetente@gmail.com","destinatario@gmail.com","Inbox","Assunto","corpo"),
        Email(3,4,"remetente@gmail.com","destinatario@gmail.com","Inbox","Assunto","corpo"),
        Email(4,4,"remetente@gmail.com","destinatario@gmail.com","Inbox","Assunto","corpo"),
        Email(5,4,"remetente@gmail.com","destinatario@gmail.com","Inbox","Assunto","corpo")

    )
}
