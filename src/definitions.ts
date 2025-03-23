import { PluginListenerHandle } from "@capacitor/core";

export interface TcpSocketPluginPlugin {
  /**
   * Établit une connexion avec un serveur TCP
   * @param options Contient l'hôte et le port du serveur
   */
  connect(options: { host: string; port: number }): Promise<void>;

  /**
   * Envoie un message au serveur
   * @param options Contient le message à envoyer
   */
  send(options: { message: string }): Promise<void>;

  /**
   * Ferme la connexion au serveur
   */
  close(): Promise<void>;

  /**
   * Événement déclenché lorsqu'un message est reçu
   */
  addListener(
    eventName: 'dataReceived',
    listenerFunc: (data: { message: string }) => void
  ): Promise<PluginListenerHandle>;
}
