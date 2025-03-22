export interface TcpSocketPluginPlugin {
   // Méthode pour établir une connexion
   connect(options: { host: string, port: number }): Promise<void>;

   // Méthode pour envoyer un message
   send(options: { message: string }): Promise<void>;
 
   // Méthode pour fermer la connexion
   close(): Promise<void>;
}
