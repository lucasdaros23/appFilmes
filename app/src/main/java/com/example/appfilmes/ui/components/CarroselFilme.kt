import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appfilmes.ui.components.Filme

@Composable
fun FilmeCarouselCard(filme: Filme) {
    Box(
        modifier = Modifier
            .width(160.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFF1A1A1A))
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            // Tela branca onde ficaria a imagem do filme
            Box(
                modifier = Modifier
                    .height(220.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.White)
            )

            // Nota com ícone de estrela e título
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Rating",
                        tint = Color.Yellow,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "4.${(1..9).random()}",
                        color = Color.White,
                        modifier = Modifier.padding(start = 4.dp),
                        fontSize = 13.sp
                    )
                }

                Text(
                    text = filme.titulo,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top = 6.dp)
                )
            }
        }
    }
}