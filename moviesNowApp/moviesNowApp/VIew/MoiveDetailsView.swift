import SwiftUI

struct MovieDetailView: View {
    let movieTitle: String = "Inception"
    let movieDescription: String = "A skilled thief is offered a chance to have his past crimes forgiven..."
    let releaseYear: String = "2010"
    let duration: String = "2,47 horas"
    let rating: String = "8.8/10"
    let youtubeVideoURL: String = "https://www.youtube.com/embed/YoJk-4z2u54" // Substitua pela URL de incorporação do vídeo de Inception

    var body: some View {
        VStack(spacing: 0) {
            // MARK: - Video Miniplayer
            ZStack(alignment: .bottomTrailing) {
                WebView(urlString: youtubeVideoURL)
                    .frame(height: 200) // Altura do miniplayer
            }
            
            // MARK: - Movie Details Section
            HStack(alignment: .top) {
                // Movie Poster / Thumbnail
                VStack {
                    AsyncImage(url: posterImageURL) { phase in
                        switch phase {
                        case .empty:
                            ProgressView() // Mostra um indicador de carregamento enquanto a imagem carrega
                                .frame(width: 120, height: 180)
                        case .success(let image):
                            image
                                .resizable()
                                .aspectRatio(contentMode: .fit)
                                .frame(width: 120, height: 180)
                                .cornerRadius(8)
                        case .failure:
                            Image(systemName: "photo") // Mostra um ícone de placeholder em caso de erro
                                .resizable()
                                .aspectRatio(contentMode: .fit)
                                .frame(width: 120, height: 180)
                                .foregroundColor(.gray)
                        @unknown default:
                            EmptyView()
                        }
                    }
                    Spacer() // Empurra o conteúdo para cima
                }
                .padding(.leading)

                // Movie Information
                VStack(alignment: .leading, spacing: 5) {
                    Text(movieDescription)
                        .font(.callout)
                        .foregroundColor(.red)
                        .multilineTextAlignment(.leading)
                    
                    Text(releaseYear)
                        .font(.subheadline)
                        .foregroundColor(.red)
                    
                    Text(duration)
                        .font(.subheadline)
                        .foregroundColor(.red)
                    
                    HStack {
                        Image(systemName: "star.fill")
                            .foregroundColor(.yellow)
                        Text(rating)
                            .font(.headline)
                            .foregroundColor(.red)
                    }
                }
                .padding(.horizontal)
                Spacer() // Empurra o conteúdo para a esquerda
            }
            .padding(.top, 16)

            Spacer() // Empurra tudo para cima

            // MARK: - Bottom Navigation Bar (Assuming simple representation)
            HStack {
                Spacer()
                Image(systemName: "line.horizontal.3") // Exemplo de ícone
                    .font(.title2)
                    .foregroundColor(.white)
                Spacer()
                Image(systemName: "circle.fill") // Exemplo de ícone
                    .font(.title2)
                    .foregroundColor(.white)
                Spacer()
                Image(systemName: "chevron.left") // Exemplo de ícone
                    .font(.title2)
                    .foregroundColor(.white)
                Spacer()
            }
            .padding(.bottom, 20) // Espaçamento da parte inferior
            .background(Color.black.opacity(0.8)) // Fundo da barra de navegação
        }
        .background(Color.black.edgesIgnoringSafeArea(.all)) // Fundo preto para toda a tela
        .navigationBarHidden(true) // Oculta a barra de navegação padrão
        .navigationBarTitleDisplayMode(.inline) // Define o modo de exibição do título
        .overlay(
            // Top Bar with "Inception" title and back button
            HStack {
                Button(action: {
                    // Action for back button
                }) {
                    Image(systemName: "arrow.left")
                        .foregroundColor(.white)
                }
                Text(movieTitle)
                    .font(.title2)
                    .fontWeight(.bold)
                    .foregroundColor(.red)
                Spacer()
                // You can add more icons here like in the original image (wifi, battery, etc.)
                // For simplicity, I'm omitting them but they would be Image(systemName: "...")
                Text("96%")
                    .foregroundColor(.white)
                Image(systemName: "wifi")
                    .foregroundColor(.white)
                Image(systemName: "battery.100")
                    .foregroundColor(.white)
            }
            .padding(.horizontal)
            .padding(.top, UIApplication.shared.windows.first?.safeAreaInsets.top ?? 0) // Ajusta para a área segura
            .frame(height: 60)
            .background(Color.black.opacity(0.8).edgesIgnoringSafeArea(.top))
            , alignment: .top
        )
    }
}


// MARK: - Preview Provider
struct MovieDetailView_Previews: PreviewProvider {
    static var previews: some View {
        MovieDetailView()
    }
}