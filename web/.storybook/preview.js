import './style.css'
import { registerIconLibrary } from '@shoelace-style/shoelace/dist/utilities/icon-library'

registerIconLibrary('fa', {
  resolver: name => {
    const filename = name.replace(/^fa[rbsl]-/, '')
    let folder = ''
    if (name.substring(0, 4) === 'fas-') folder = 'solid'
    if (name.substring(0, 4) === 'fab-') folder = 'brands'
    if (name.substring(0, 4) === 'far-') folder = 'regular'
    if (name.substring(0, 4) === 'fal-') folder = 'light'
    return `./fontawesome-pro-5.15.4-web/svgs/${folder}/${filename}.svg`
  },
  mutator: svg => svg.setAttribute('fill', 'currentColor')
})

/** @type { import('@storybook/web-components').Preview } */
const preview = {
  parameters: {
    actions: { argTypesRegex: '^on[A-Z].*' },
    controls: {
      matchers: {
        color: /(background|color)$/i,
        date: /Date$/i
      }
    }
  }
}

export default preview
