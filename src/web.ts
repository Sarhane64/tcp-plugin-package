import { WebPlugin } from '@capacitor/core';

import type { TcpSocketPluginPlugin } from './definitions';

export class TcpSocketPluginWeb extends WebPlugin implements TcpSocketPluginPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
