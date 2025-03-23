export interface TcpSocketPluginPlugin {
  // Méthode pour établir une connexion
  connect(options: { host: string, port: number }): Promise<void>;

  // Méthode pour envoyer un message et écouter la réponse
  send(options: { message: string }): Promise<void>;

  // Méthode pour fermer la connexion
  close(): Promise<void>;

  // Méthode pour écouter la réponse du serveur (optionnelle si nécessaire)
  listen(): Promise<void>;
}
