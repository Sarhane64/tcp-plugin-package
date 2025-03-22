export interface TcpSocketPluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
