import { WebPlugin } from '@capacitor/core';

import type { TcpSocketPluginPlugin } from './definitions';

export class TcpSocketPluginWeb extends WebPlugin implements TcpSocketPluginPlugin {
  async connect(options: { host: string; port: number }): Promise<void> {
    console.log('Web does not support TCP connection', options);
  }

  async send(options: { message: string }): Promise<void> {
    console.log('Web does not support sending TCP messages', options);
  }

  async close(): Promise<void> {
    console.log('Web does not support closing TCP connection');
  }
}
